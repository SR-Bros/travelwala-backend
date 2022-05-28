package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.repository.core.WalaRepository;

import java.util.List;

public interface FlightRepository extends WalaRepository<Flight, String> {
    List<Flight> findWithCriteria(FlightCriteria flightCriteria);
}
