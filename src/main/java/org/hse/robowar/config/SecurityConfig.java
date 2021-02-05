package org.hse.robowar.config;

import lombok.AllArgsConstructor;
import org.hse.robowar.constant.StringConstant;
import org.hse.robowar.security.jwt.JwtConfigurer;
import org.hse.robowar.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;

    private final String[] standartMatchers = {"/actuator/**",
            "/swagger-ui.html**",
            "/v2/api-docs/**",
            "/swagger-resources/**",
            "/webjars/springfox-swagger-ui/**"};

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(StringConstant.PUBLIC_ENDPOINT).permitAll()
                .antMatchers(standartMatchers).permitAll()
                .antMatchers(StringConstant.ADMIN_ENDPOINT).hasRole(StringConstant.ROLE_ADMIN_CODE)
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
