package com.accesstech.accesstech.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Balance {

    String code;
    String message;
    String balance;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
