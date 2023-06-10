package com.fanta.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorEntity implements Entity {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;

    public ActorEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public List<String> getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(List<String> validationMessage) {
        this.validationMessage = validationMessage;
    }

    private List<String> validationMessage;

}
