package org.hse.robowar.repository;

import org.hse.robowar.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Account findByLogin(String login);

}
