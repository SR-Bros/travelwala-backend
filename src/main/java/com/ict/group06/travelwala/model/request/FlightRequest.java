package com.ict.group06.travelwala.model.request;

import com.ict.group06.travelwala.entity.flight.Plane;
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
    private String departureAirport;
    private String arrivalAirport;
    private String agencyId;
    private String planeId;
    private LocalDateTime departureTime;
    private LocalDateTime expectedArrivalTime;
}
