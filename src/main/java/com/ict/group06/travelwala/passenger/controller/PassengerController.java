package com.ict.group06.travelwala.passenger.controller;

import com.ict.group06.travelwala.model.request.PassengerRequest;
import com.ict.group06.travelwala.passenger.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/passsengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public ResponseEntity<?> savePassenger(PassengerRequest passengerRequest) {
        try {
            return ResponseEntity.ok().body(passengerService.savePassenger(passengerRequest));
        } catch (Exception e) {
            return ResponseEntity.status(422).body("Something bad occurred");
        }
    }
}
