package com.ict.group06.travelwala.repository.impl;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.repository.FlightRepository;
import com.ict.group06.travelwala.repository.core.WalaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightRepositoryImpl extends WalaRepositoryImpl<Flight, String> implements FlightRepository {
    @Autowired
    public FlightRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Flight.class);
    }

    @Override
    public List<Flight> findWithCriteria(FlightCriteria flightCriteria) {
        return null;
    }
}
