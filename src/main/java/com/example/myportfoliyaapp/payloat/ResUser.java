package com.example.myportfoliyaapp.payloat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ResUser {
    private String phoneNumber;
    private String password;
    private String userName;
    private String birthDate;
  //  private UUID productId;

    public ResUser(String phoneNumber, String password, String userName, String birthDate) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;
        this.birthDate = birthDate;
    }
}
