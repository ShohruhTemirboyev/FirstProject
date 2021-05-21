package com.example.myportfoliyaapp.payloat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiJwtRespons  {
    private String message;
    private boolean success;
    private UUID userId;
    private String token;
    private String tokenType = "Tusiq";

    public ApiJwtRespons(String token) {
        this.token = token;
    }


}
