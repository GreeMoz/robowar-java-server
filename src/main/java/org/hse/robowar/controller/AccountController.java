package org.hse.robowar.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.dto.mapper.AccountMapper;
import org.hse.robowar.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
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

    @SneakyThrows
    @GetMapping
    public List<AccountDTO> findAll() {
        if (accountService.getByAuth().getRoles().stream().noneMatch(role -> role.getCode() == "ADMIN")) {
            throw new AccessDeniedException("You haven't enough right");
        }
        return accountMapper.toDto(accountService.findAll());
    }

    @GetMapping("/get")
    public AccountDTO getByAuth(){
        return accountMapper.toDto(accountService.getByAuth());
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public AccountDTO findOne(@PathVariable("id") UUID id) {
        if (accountService.getByAuth().getRoles().stream().noneMatch(role -> role.getCode() == "ADMIN")) {
            throw new AccessDeniedException("You haven't enough right");
        }
        return accountMapper.toDto(accountService.findById(id));
    }
}
