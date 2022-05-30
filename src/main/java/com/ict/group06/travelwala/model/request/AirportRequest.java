package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportRequest {
    private String name;
    private String city;
    private String country;
}
