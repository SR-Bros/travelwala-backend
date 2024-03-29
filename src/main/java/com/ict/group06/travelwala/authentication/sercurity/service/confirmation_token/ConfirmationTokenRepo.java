package com.ict.group06.travelwala.authentication.sercurity.service.confirmation_token;

import com.ict.group06.travelwala.authentication.sercurity.entity.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepo extends MongoRepository<ConfirmationToken,String> {
    Optional<ConfirmationToken> findByToken(String token);
}
