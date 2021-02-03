package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.mapper.AccountMapper;
import org.hse.robowar.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public AccountDTO create() {
        return null;
    }

    @GetMapping
    public List<AccountDTO> findAll() {
        return accountMapper.toDto(accountService.findAll());
    }

}
