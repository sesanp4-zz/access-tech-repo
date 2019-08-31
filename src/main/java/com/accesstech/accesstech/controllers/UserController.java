package com.accesstech.accesstech.controllers;

import com.accesstech.accesstech.model.Balance;
import com.accesstech.accesstech.model.Login;
import com.accesstech.accesstech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(path="merchant")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "auth",consumes = "application/json",produces = "application/json")
    public String auth(@RequestBody Login login) throws IOException {
          return userService.authneticate(login);
    }

    @PostMapping(path = "token",consumes = "application/json",produces = "application/json")
    public String getToken(@RequestBody Login login) throws IOException {
        return userService.getToken(login);
    }

    @GetMapping(path = "balance",produces = "application/json")
    public Balance getToken(@RequestHeader(name = "Authorization") String token) throws IOException {
        return userService.getBalance(token);
    }


}
