package by.market.security;

import by.market.security.domain.User;
import by.market.security.impl.JwtUser;

public interface JwtUserFactory {

    JwtUser create(User user);

}
