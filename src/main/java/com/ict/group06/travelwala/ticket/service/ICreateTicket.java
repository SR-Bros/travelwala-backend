package com.ict.group06.travelwala.ticket.service;

import com.ict.group06.travelwala.model.request.PassengerRequest;
import com.ict.group06.travelwala.model.response.CreateTicketResponse;

import java.util.List;

public interface ICreateTicket {
    CreateTicketResponse createTickets(List<PassengerRequest> passengers, String flightId, String seatClass);
}
