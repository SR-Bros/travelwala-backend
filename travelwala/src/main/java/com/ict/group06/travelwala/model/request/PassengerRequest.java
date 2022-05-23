package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerRequest {
    private String title;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String nationality;
}
