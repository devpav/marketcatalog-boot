package by.market.security.config;

import by.market.security.JwtTokenService;
import by.market.security.JwtUserFactory;
import by.market.security.impl.JwtTokenServiceImpl;
import by.market.security.impl.JwtUserFactoryImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "marketcatalog.security", matchIfMissing = true, havingValue = "true")
public class JwtConfiguration {

    @Bean
    public JwtTokenService jwtTokenService() {
        return new JwtTokenServiceImpl();
    }

    @Bean
    public JwtUserFactory jwtUserFactory() {
        return new JwtUserFactoryImpl();
    }


}
