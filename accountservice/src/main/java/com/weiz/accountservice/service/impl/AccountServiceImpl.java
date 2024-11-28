package com.weiz.accountservice.service.impl;

import com.weiz.accountservice.entity.Account;
import com.weiz.accountservice.model.AccountDTO;
import com.weiz.accountservice.repository.AccountRepository;
import com.weiz.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public void add(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        //account.setPassword(new BCryptPasswordEncoder().encode(accountDTO.getPassword()));

        accountRepository.save(account);

        accountDTO.setId(account.getId());
    }

    @Override
    public void update(AccountDTO accountDTO) {
        Account account = accountRepository.getById(accountDTO.getId());
        if (account != null) {
            modelMapper.typeMap(AccountDTO.class, Account.class)
                    .addMappings(mapper -> mapper.skip(Account::setPassword)).map(accountDTO, account);

            accountRepository.save(account);
        }
    }

    @Override
    public void updatePassword(AccountDTO accountDTO) {
        Account account = accountRepository.getById(accountDTO.getId());
        if (account != null) {
            //account.setPassword(new BCryptPasswordEncoder().encode(accountDTO.getPassword()));
            accountRepository.save(account);
        }
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.getById(id);
        if (account != null) {
            accountRepository.delete(account);
        }
    }

    @Override
    public List<AccountDTO> getAll() {
        logger.info("Get all accounts");
        List<AccountDTO> accountDTOs = new ArrayList<>();

        accountRepository.findAll().forEach((account) -> {
            accountDTOs.add(modelMapper.map(account, AccountDTO.class));
        });

        return accountDTOs;
    }

    @Override
    public AccountDTO getById(Long id) {
        Account account = accountRepository.getById(id);

        if (account != null) {
            return modelMapper.map(account, AccountDTO.class);
        }

        return null;
    }
}
