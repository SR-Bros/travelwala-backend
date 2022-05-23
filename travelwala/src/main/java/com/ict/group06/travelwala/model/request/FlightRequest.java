package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest {
    private String code;
    private Double adultEconomicPrice;
    private Double adultBusinessPrice;
    private Double discountRate;
    private String departureCity;
    private String departureAirport;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime expectedArrivalTime;
}
