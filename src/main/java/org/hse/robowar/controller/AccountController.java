package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.mapper.AccountMapper;
import org.hse.robowar.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping
    public List<AccountDTO> findAll() {
        return accountMapper.toDto(accountService.findAll());
    }

    @GetMapping("/get")
    public AccountDTO getByAuth(){
        return accountMapper.toDto(accountService.getByAuth());
    }

    @GetMapping("/{id}")
    public AccountDTO findOne(@PathVariable("id") UUID id) {
        return accountMapper.toDto(accountService.findById(id));
    }
}
