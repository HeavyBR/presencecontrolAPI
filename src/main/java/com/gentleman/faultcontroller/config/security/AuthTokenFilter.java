package com.gentleman.faultcontroller.config.security;

import com.gentleman.faultcontroller.domain.User;
import com.gentleman.faultcontroller.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {


    private final AuthTokenService tokenService;
    private final UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = retrieveToken(request);

        boolean isvalidToken = tokenService.isTokenValid(token);

        if (isvalidToken) {
            authClient(token);
        }

        filterChain.doFilter(request,response);

    }

    private void authClient(String token) {
        Integer id = tokenService.getUserId(token);
        User usuario = repository.findById(id).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String retrieveToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if(authorization == null || authorization.isEmpty() || authorization.isBlank() || !authorization.startsWith("Bearer")) {
            return null;
        }

        return authorization.substring(7);

    }
}
