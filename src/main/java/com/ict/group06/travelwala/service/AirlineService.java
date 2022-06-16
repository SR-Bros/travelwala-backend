package com.ict.group06.travelwala.service;

import com.ict.group06.travelwala.model.request.AirlineRequest;
import com.ict.group06.travelwala.model.response.AirlineResponse;

import java.util.List;

public interface AirlineService {
    List<AirlineResponse> findAll();
    AirlineResponse findById(String id);
    AirlineResponse createNewAirline(AirlineRequest airlineRequest);
}
