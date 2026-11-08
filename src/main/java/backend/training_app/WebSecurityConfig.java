package backend.training_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled=true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/", "/index", "/programs", "/css/**", "/rest/programs").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(formlogin -> formlogin
            .loginPage("/login")
            .defaultSuccessUrl("/programs", true)
            .permitAll()
        );
        return http.build();
        
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
