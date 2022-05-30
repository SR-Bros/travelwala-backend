package com.ict.group06.travelwala.model.response;

import com.ict.group06.travelwala.entity.flight.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportResponse {
    private String id;
    private String name;
    private String city;
    private String country;

    public AirportResponse(Airport airport) {
        this(airport.getId(), airport.getName(), airport.getCity(), airport.getCountry());
    }
}
