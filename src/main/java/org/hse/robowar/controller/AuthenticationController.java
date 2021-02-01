package org.hse.robowar.controller;

import lombok.AllArgsConstructor;
import org.hse.robowar.dto.AuthenticationRequestDTO;
import org.hse.robowar.dto.AuthenticationResponseDTO;
import org.hse.robowar.model.Account;
import org.hse.robowar.security.jwt.JwtTokenProvider;
import org.hse.robowar.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final AccountService accountService;

    @PostMapping("/public/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AuthenticationRequestDTO requestDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    requestDTO.getLogin(), requestDTO.getPassword()
            ));
            Account account = accountService.findByLogin(requestDTO.getLogin());

            if (Objects.isNull(account)) {
                throw new UsernameNotFoundException("User with login: " + requestDTO.getLogin() + " not found");
            }
            String token = tokenProvider.createToken(account.getLogin(), account.getRoles());
            return ResponseEntity.ok(new AuthenticationResponseDTO(account.getLogin(), token));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}
