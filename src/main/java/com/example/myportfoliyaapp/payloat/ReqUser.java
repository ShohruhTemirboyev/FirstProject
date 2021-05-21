package com.example.myportfoliyaapp.payloat;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqUser {
    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$",message = "Phone number must be 13 digits.")
    private String phoneNumber;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Password must be such")
    private String password;
    private String userName;
    private String birthDate;
}
