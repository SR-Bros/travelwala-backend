package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.request.FlightRequest;
import com.ict.group06.travelwala.model.response.FlightResponse;
import com.ict.group06.travelwala.repository.FlightRepository;
import com.ict.group06.travelwala.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<FlightResponse> findAll(FlightCriteria flightCriteria) {
        return null;
    }

    @Override
    public FlightResponse findById(String id) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("No flight found for id " + id)
        );
        return new FlightResponse(flight);
    }

    @Override
    public FlightResponse createNewFlight(FlightRequest flightRequest) {
        return null;
    }

    @Override
    public FlightResponse updateFlight(String id, FlightRequest flightRequest) {
        return null;
    }
}
