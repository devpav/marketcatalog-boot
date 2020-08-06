package by.market.security.impl;

import by.market.security.JwtUserFactory;
import by.market.security.domain.User;
import by.market.security.SecurityUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserService implements UserDetailsService {

    private final SecurityUserService securityUserService;
    private final JwtUserFactory jwtUserFactory;

    public JwtUserService(SecurityUserService securityUserService, JwtUserFactory jwtUserFactory) {
        this.securityUserService = securityUserService;
        this.jwtUserFactory = jwtUserFactory;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User voterEntity = securityUserService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found by " + username));

        return jwtUserFactory.create(voterEntity);
    }

}
