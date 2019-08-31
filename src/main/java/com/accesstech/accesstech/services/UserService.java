package com.accesstech.accesstech.services;

import com.accesstech.accesstech.model.Balance;
import com.accesstech.accesstech.model.Login;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class UserService {

    @Autowired
     ThirdPartyService thirdPartyService;

    Balance balance;

    JsonObject obj;
    Gson gson = new Gson();
    JsonParser parser;

    public String authneticate(Login login) throws IOException {

        return thirdPartyService.auth(login);

    }


    public String getToken(Login login) throws IOException {

        return thirdPartyService.getToken(login);

    }

    public Balance getBalance(String token) throws IOException {
         balance= new Balance();
         String info = thirdPartyService.getBalance(token);
         obj = new JsonParser().parse(info).getAsJsonObject();
         balance.setCode("00");
         balance.setMessage("successful");
         balance.setBalance(obj.get("balance").getAsString());
        return balance;
    }

}
