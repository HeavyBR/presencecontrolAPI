package com.gentleman.faultcontroller.requests;


import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginRequest {
    private final String email;
    private final String password;


    public UsernamePasswordAuthenticationToken convertToAuthObj() {
        return new UsernamePasswordAuthenticationToken(this.getEmail(), this.getPassword());
    }
}
