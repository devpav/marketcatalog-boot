package by.market.security.impl;

import by.market.security.domain.Authority;
import by.market.security.JwtUserFactory;
import by.market.security.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactoryImpl implements JwtUserFactory {

    public JwtUser create(User user) {
        final List<GrantedAuthority> grantedAuthorities = mapToGrantedAuthorities(user.getAuthorities());

        return JwtUser.builder()
                .id(user.getId())
                .login(user.getUsername())
                .password(user.getPassword())
                .lastPasswordResetDate(user.getLastPasswordResetDate())
                .authorities(grantedAuthorities)
                .build();
    }

    private List<GrantedAuthority> mapToGrantedAuthorities(Collection<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getTitle()))
                .collect(Collectors.toList());
    }

}
