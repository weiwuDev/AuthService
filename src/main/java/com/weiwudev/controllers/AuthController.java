package com.weiwudev.controllers;


import com.weiwudev.models.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;


@RestController
public class AuthController {

    @PostMapping("/login")
    public Mono<ResponseEntity<ResponseObject>> login(WebSession webSession) {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Login Successful", webSession.getId())));

    }

    @PutMapping("/logout")
    public Mono<ResponseEntity<ResponseObject>> logout(WebSession webSession) {
        webSession.invalidate();
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Login Successful", webSession.getId())));
    }

}
