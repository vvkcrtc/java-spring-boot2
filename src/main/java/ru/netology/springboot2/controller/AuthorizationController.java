package ru.netology.springboot2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springboot2.exception.InvalidCredentials;
import ru.netology.springboot2.exception.UnauthorizedUser;
import ru.netology.springboot2.service.Authorities;
import ru.netology.springboot2.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") @Validated String user, @RequestParam("password") @Validated String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e) {
        System.out.println(e);
        return new ResponseEntity<>("Invalid Credentials " + e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> icHandler(UnauthorizedUser e) {
        System.out.println(e);
        return new ResponseEntity<>("Unauthorized User " + e, HttpStatus.UNAUTHORIZED);
    }

}
