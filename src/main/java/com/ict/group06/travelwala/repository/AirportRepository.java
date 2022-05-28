package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
    Optional<Airport> findByName(String name);
}
