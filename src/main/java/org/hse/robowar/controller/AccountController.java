package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.mapper.AccountMapper;
import org.hse.robowar.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public AccountDTO create(@RequestBody AccountDTO account) {
        return accountMapper.toDto(accountService.insert(accountMapper.toEntity(account)));
    }

    @GetMapping
    public List<AccountDTO> findAll() {
        return accountMapper.toDto(accountService.findAll());
    }

    @GetMapping("/{id}")
    public AccountDTO findOne(@PathVariable("id") UUID id) {
        return accountMapper.toDto(accountService.findById(id));
    }
}
