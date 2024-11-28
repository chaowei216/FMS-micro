package com.weiz.clientregisterservice.repository;

import com.weiz.clientregisterservice.entitty.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByClientId(String clientId);

    void deleteByClientId(String clientId);
}
