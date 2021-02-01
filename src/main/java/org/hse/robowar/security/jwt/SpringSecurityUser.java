package org.hse.robowar.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Data
public class SpringSecurityUser implements UserDetails {

    private UUID accountId;
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private final Collection<? extends GrantedAuthority> authorities;

    protected boolean accountNonExpired = true;
    protected boolean accountNonLocked = true;
    protected boolean credentialsNonExpired = true;
    protected boolean enabled = true;

    public SpringSecurityUser(UUID accountId, String username, String password, String firstName, String lastName, String email, Collection<? extends GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.authorities = authorities;
    }
}
