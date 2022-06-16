package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Airline;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirlineRepository extends MongoRepository<Airline, String> {
}
