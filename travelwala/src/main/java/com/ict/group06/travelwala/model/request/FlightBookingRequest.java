package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {
    private TicketRequest[] ticketRequests;
}
