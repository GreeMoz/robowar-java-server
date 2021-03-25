package org.hse.robowar.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.mapper.AccountMapper;
import org.hse.robowar.model.Account;
import org.hse.robowar.enums.Status;
import org.hse.robowar.repository.AccountRepository;
import org.hse.robowar.repository.RoleRepository;
import org.hse.robowar.service.AccountService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Account insert(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setStatus(Status.ACTIVE);

        Account savedAccount = accountRepository.save(account);

        log.info("Account with login {} successfully inserted", account.getLogin());

        return savedAccount;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    @Override
    public Account findById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manager with id " + id.toString() + " is not exist"));
    }

    @Override
    public void delete(UUID id) {
        accountRepository.deleteById(id);
        log.info("Account with id {} successfully deleted", id.toString());
    }

    @Override
    public Account getByAuth() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return findByUsername(userDetails.getUsername());
    }

    private Account findByUsername(String username){
        Account account = accountRepository.findByLogin(username);
        log.info("Account with id {} successfully loaded", account.getLogin());
        return account;
    }
}
