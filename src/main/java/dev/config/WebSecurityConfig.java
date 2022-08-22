package dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityConfig(JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // désactivation de la protection CSRF
                // non utilisée dans le cadre d'une Web API
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()
//                .antMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/admin").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/admin").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/admin").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/admin").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/login").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .antMatchers(HttpMethod.GET, "/signup").permitAll()
//                .antMatchers(HttpMethod.POST, "/signup").permitAll()
//                .anyRequest().authenticated()
                .and().headers().frameOptions().disable()
                .and()
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutSuccessHandler(((request, response, authentication) -> response.setStatus(HttpStatus.OK.value())))
                .deleteCookies(TOKEN_COOKIE);
                // Les autres requêtes sont soumises à authentification
        return http.build();
    }
}