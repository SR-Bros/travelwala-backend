package com.ict.group06.travelwala.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
