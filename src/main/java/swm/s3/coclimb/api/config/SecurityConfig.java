package swm.s3.coclimb.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .anyRequest()
                .permitAll()
        );

        // h2-console settings
        http.headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions
                        .disable()
                ));

        return http.build();
    }
}