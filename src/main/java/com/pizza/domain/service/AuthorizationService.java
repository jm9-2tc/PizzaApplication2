package com.pizza.domain.service;

import com.pizza.domain.exception.UnauthorizedException;

public class AuthorizationService {
    public static void checkToken(String token){
        if(token == null || !token.equals("")){
            throw new UnauthorizedException("Błędny token");
        }
    }
}
