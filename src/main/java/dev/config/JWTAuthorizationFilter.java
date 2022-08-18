package dev.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Value("AUTH-TOKEN")
    private String TOKEN_COOKIE;

    private SecretKey secretKey;

    public JWTAuthorizationFilter(SecretKey secretKey) {
        this.secretKey = secretKey;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getCookies() != null) {
            Stream.of(request.getCookies())
                    .filter(cookie -> cookie.getName().equals(TOKEN_COOKIE))
                    .map(Cookie::getValue)
                    .forEach(token -> {
                        Claims body = Jwts.parserBuilder()
                                .setSigningKey(secretKey)
                                .build()
                                .parseClaimsJws(token)
                                .getBody();

                        String username = body.getSubject();

                        Integer roles = body.get("roles", Integer.class);

                        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(roles.toString()));
//                                .stream()
//                                .map(SimpleGrantedAuthority::new).toList();
                        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    });
        }
        filterChain.doFilter(request, response);
    }
}
