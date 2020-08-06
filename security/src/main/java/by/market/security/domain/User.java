package by.market.security.domain;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public interface User {

    UUID getId();

    String getUsername();

    String getPassword();

    Collection<Authority> getAuthorities();

    Date getLastPasswordResetDate();

}
