package com.beomchul.springboot.mywebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("beomchul");
        boolean isValidPassword = password.equalsIgnoreCase("aaa");

        return isValidUserName && isValidPassword;
    }
}
