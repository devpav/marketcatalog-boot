package by.market.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtTokenService {

    Boolean canTokenBeRefreshed(String token, Date lastPasswordReset);

    String generateToken(UserDetails userDetails);

    String refreshToken(String token);

    String getUsernameFromToken(String token);

    Boolean validateToken(String token, UserDetails userDetails);

}

