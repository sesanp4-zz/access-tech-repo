package com.accesstech.accesstech.controllers;

import com.accesstech.accesstech.model.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "test")
public class Test {

   @Autowired
    TestResponse testResponse;

    @GetMapping(produces = "application/json", path = "api")
    public TestResponse check(){
        testResponse.setCode("00");
        testResponse.setMessage("successfull");
        return testResponse;
    }



}
