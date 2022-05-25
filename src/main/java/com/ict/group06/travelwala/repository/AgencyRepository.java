package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.Agency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgencyRepository extends MongoRepository<Agency, Long> {
}
