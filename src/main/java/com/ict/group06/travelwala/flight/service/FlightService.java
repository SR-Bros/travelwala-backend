package com.ict.group06.travelwala.flight.service;

import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.response.FlightResponse;
import com.ict.group06.travelwala.model.request.FlightRequest;
import com.ict.group06.travelwala.model.response.SearchFlightResponse;

public interface FlightService {
    SearchFlightResponse findAll(FlightCriteria flightCriteria);
    FlightResponse findById(String id);
    FlightResponse createNewFlight(FlightRequest flightRequest);
    FlightResponse updateFlight(String id, FlightRequest flightRequest);
}
