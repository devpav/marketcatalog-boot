package by.market.security;


import by.market.security.domain.User;

import java.util.Optional;

public interface SecurityUserService {

    Optional<User> findByUsername(String username);

}
