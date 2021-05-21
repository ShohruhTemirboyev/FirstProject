package com.example.myportfoliyaapp.payloat;

import lombok.Data;

@Data
public class JwtRespons {
private String token;
private String tokenType="Tusiq";

    public JwtRespons(String token) {
        this.token = token;
    }
}
