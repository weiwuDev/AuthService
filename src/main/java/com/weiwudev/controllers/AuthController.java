package com.weiwudev.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class AuthController {

    @PostMapping("/login")
    public Mono<String> login(WebSession webSession) {
        return Mono.just("Login Successful");
    }

    @PutMapping("/logout")
    public Mono<String> logout(WebSession webSession) {
        webSession.invalidate();
        return Mono.just("Logout Successful");
    }

}
