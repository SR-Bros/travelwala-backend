package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
