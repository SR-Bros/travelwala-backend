package com.ict.group06.travelwala.service;

import com.ict.group06.travelwala.model.request.AirportRequest;
import com.ict.group06.travelwala.model.response.AirportResponse;

import java.util.List;

public interface AirportService {
    List<AirportResponse> findAll();
    AirportResponse findById(String id);
    AirportResponse createNewAirport(AirportRequest airportRequest);
    AirportResponse updateAirport(String id, AirportRequest airportRequest);
}
