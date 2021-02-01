package org.hse.robowar.security.jwt;

import org.hse.robowar.model.Account;
import org.hse.robowar.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static SpringSecurityUser create(Account account) {
        return new SpringSecurityUser(
                account.getId(),
                account.getLogin(),
                account.getPassword(),
                account.getFirstName(),
                account.getLastName(),
                account.getEmail(),
                mapToGrantedAuthority(account.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getCode()))
                .collect(Collectors.toList());
    }
}
