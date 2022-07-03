package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingFlightSpecs {
    private TravellerSpecs travellerSpecs;
    private FlightProductSpecs flightProductSpecs;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TravellerSpecs {
        private List<PassengerRequest> adultFormData;
        private List<PassengerRequest> childFormData;
        private List<PassengerRequest> infantFormData;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FlightProductSpecs {
        private String flightId;
        private String seatClass;
        private Integer adultCount;
        private Integer childCount;
        private Integer infantCount;
    }
}
