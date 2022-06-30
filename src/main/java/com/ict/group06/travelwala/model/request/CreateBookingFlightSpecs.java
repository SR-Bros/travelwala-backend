package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
        private PassengerRequest[] adultFormData;
        private PassengerRequest[] childFormData;
        private PassengerRequest[] infantFormData;
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
