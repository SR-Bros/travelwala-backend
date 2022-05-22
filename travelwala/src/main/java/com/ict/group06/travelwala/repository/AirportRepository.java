package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {

}
