package com.accesstech.accesstech.services;

import com.accesstech.accesstech.model.Login;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Service
public class ThirdPartyService {


    JsonObject obj,obj2;
    CloseableHttpClient client   = HttpClients.createDefault();
    HttpPost post;
    HttpGet get;
    CloseableHttpResponse response;
    Gson gson = new Gson();

    public String auth(Login login) throws IOException {

        post = new HttpPost("https://clients.primeairtime.com/api/auth");
        post.setHeader("Content-Type", "application/json");
        StringEntity ent = new StringEntity(gson.toJson(login));
        post.setEntity(ent);
        response=client.execute(post);
        String msg = EntityUtils.toString(response.getEntity());
        obj = new JsonParser().parse(msg).getAsJsonObject();

        if(obj.has("token")){
            return "authentication successful";
        }else{
            return "authentication failed";
        }

    }


    public String getToken(Login login) throws IOException {

        post = new HttpPost("https://clients.primeairtime.com/api/auth");
        post.setHeader("Content-Type", "application/json");
        StringEntity ent = new StringEntity(gson.toJson(login));
        post.setEntity(ent);
        response=client.execute(post);
        String msg = EntityUtils.toString(response.getEntity());
        obj = new JsonParser().parse(msg).getAsJsonObject();
        return obj.toString();
    }


    public String getBalance(String token) throws IOException {
        get = new HttpGet("https://clients.primeairtime.com/api/status");
        get.setHeader("Authorization", token);
        response=client.execute(get);
        String msg = EntityUtils.toString(response.getEntity());
        obj = new JsonParser().parse(msg).getAsJsonObject();
        return obj.toString();
    }


}
