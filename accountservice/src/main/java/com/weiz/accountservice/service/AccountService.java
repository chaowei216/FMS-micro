package com.weiz.accountservice.service;

import com.weiz.accountservice.model.AccountDTO;

import java.util.List;

public interface AccountService {

    void add(AccountDTO accountDTO);

    void update(AccountDTO accountDTO);

    void updatePassword(AccountDTO accountDTO);

    void delete(Long id);

    List<AccountDTO> getAll();

    AccountDTO getById(Long id);
}
