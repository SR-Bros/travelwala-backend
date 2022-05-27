package com.ict.group06.travelwala.service;

import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.request.FlightRequest;
import com.ict.group06.travelwala.model.response.FlightResponse;

import java.util.List;

//@Service
public interface FlightService {
    List<FlightResponse> findAll(FlightCriteria flightCriteria);
    FlightResponse findById(String id);
    FlightResponse createNewFlight(FlightRequest flightRequest);
    FlightResponse updateFlight(FlightRequest flightRequest);
}
