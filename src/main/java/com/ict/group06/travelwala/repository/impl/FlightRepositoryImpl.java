package com.ict.group06.travelwala.repository.impl;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.repository.FlightRepository;
import com.ict.group06.travelwala.repository.core.WalaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
        int totalPassengers = flightCriteria.getAdultCount() + flightCriteria.getChildCount() + flightCriteria.getInfantCount();
        Query query = new Query();
        if(flightCriteria.getSeatClass().equals("Economic")) {
            query.addCriteria(Criteria.where("plane.maximum_economic_capacity").gte(totalPassengers));
            System.out.println(query.toString());
            return this.mongoTemplate.find(query, Flight.class);
        }
        return null;
    }
}
