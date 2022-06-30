package com.ict.group06.travelwala.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingRequest {
    private CreateBookingFlightSpecs createBookingFlightSpecs;

    @JsonProperty("bookingContact")
    private ContactRequest contactRequest;
}
