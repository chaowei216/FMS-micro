package com.weiz.authservice.repository;

import com.weiz.authservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
