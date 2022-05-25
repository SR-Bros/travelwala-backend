package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.FlightBookingItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends MongoRepository<FlightBookingItem, String> {
}
