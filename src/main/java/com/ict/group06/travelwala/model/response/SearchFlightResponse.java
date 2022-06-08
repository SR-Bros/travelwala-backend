package com.ict.group06.travelwala.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchFlightResponse {
    private List<FlightResponse> departureFlights;
    private List<FlightResponse> returnFlights;
}
