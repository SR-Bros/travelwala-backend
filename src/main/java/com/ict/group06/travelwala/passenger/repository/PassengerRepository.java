package com.ict.group06.travelwala.passenger.repository;

import com.ict.group06.travelwala.passenger.entity.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, String> {
}
