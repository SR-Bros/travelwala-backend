package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Plane;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaneRepository extends MongoRepository<Plane, String> {
}
