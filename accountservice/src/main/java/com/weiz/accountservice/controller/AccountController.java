package com.weiz.accountservice.controller;

import com.weiz.accountservice.model.AccountDTO;
import com.weiz.accountservice.model.MessageDTO;
import com.weiz.accountservice.model.StatisticDTO;
import com.weiz.accountservice.service.AccountService;
import com.weiz.accountservice.service.NotificationService;
import com.weiz.accountservice.service.StatisticService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccountService accountService;
    private final StatisticService statisticService;
    private final NotificationService notificationService;

    // add new
    @PostMapping("/register")
    @PermitAll
    public AccountDTO register(@RequestBody AccountDTO accountDTO, @RequestHeader("Authorization") String bearerToken) {
        accountDTO.setRoles(new HashSet<>(List.of("ROLE_USER")));
        accountService.add(accountDTO);

        statisticService.add(new StatisticDTO("Account" + accountDTO.getName() + "is created", new Date()));

        // send notification
        MessageDTO messageDTO = MessageDTO.builder()
                .from("luutrieuvi2003@gmail.com")
                .to(accountDTO.getUsername())
                .toName(accountDTO.getName())
                .subject("Welcome to Weiz web")
                .content("Weiz is best website")
                .build();

        notificationService.sendNotification(messageDTO);
        return accountDTO;
    }

    // add new
    @PreAuthorize("hasAuthority('SCOPE_read') && hasRole('ADMIN')")
    @PostMapping("/account")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO, @RequestHeader("Authorization") String bearerToken) {
        accountService.add(accountDTO);
        statisticService.add(new StatisticDTO("Account" + accountDTO.getName() + "is created", new Date()));

        // send notification
        MessageDTO messageDTO = MessageDTO.builder()
                .from("luutrieuvi2003@gmail.com")
                .to(accountDTO.getUsername())
                .toName(accountDTO.getName())
                .subject("Welcome to Weiz web")
                .content("Weiz is best website")
                .build();

        notificationService.sendNotification(messageDTO);
        return accountDTO;
    }

    // get all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        logger.info("AccountService Controller: Get all accounts");

        statisticService.add(new StatisticDTO("Get all accounts", new Date()));

        return accountService.getAll();
    }

    @PreAuthorize("hasAuthority('SCOPE_read') && isAuthenticated()")
    @PostAuthorize("returnObject.body.username == authentication.name || hasRole('ADMIN')")
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(name = "id") Long id) {
        return Optional.of(new ResponseEntity<AccountDTO>(accountService.getById(id), HttpStatus.OK))
                .orElse(new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND));
    }

    @PreAuthorize("hasAuthority('SCOPE_write') && hasRole('ADMIN')")
    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        accountService.delete(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_write') && hasRole('ADMIN')")
    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        accountService.update(accountDTO);
    }
}
