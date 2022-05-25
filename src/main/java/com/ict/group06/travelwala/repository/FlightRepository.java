package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

}
