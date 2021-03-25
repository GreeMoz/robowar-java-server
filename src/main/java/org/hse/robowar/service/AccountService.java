package org.hse.robowar.service;

import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account insert(Account account);

    List<Account> findAll();

    Account findByLogin(String login);

    Account findById(UUID id);

    void delete(UUID id);

    Account getByAuth();
}
