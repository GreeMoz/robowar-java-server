package org.hse.robowar.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.model.Account;
import org.hse.robowar.security.jwt.JwtUserFactory;
import org.hse.robowar.security.jwt.SpringSecurityUser;
import org.hse.robowar.service.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByLogin(username);
        if (Objects.isNull(account)) {
            throw new UsernameNotFoundException("Account with login: " + username + " not found");
        }

        SpringSecurityUser jwtUser = JwtUserFactory.create(account);
        log.info("Account with login: {} successfully loaded", username);
        return jwtUser;
    }
}
