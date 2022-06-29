package com.ict.group06.travelwala.flight.controller;

import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.flight.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.response.FlightResponse;
import com.ict.group06.travelwala.flight.service.FlightService;
import com.ict.group06.travelwala.flight.model.request.FlightRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping ("/search")
    public ResponseEntity<?> findAll(@RequestBody FlightCriteria flightCriteria) {
        return ResponseEntity.ok(flightService.findAll(flightCriteria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(flightService.findById(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> createNewFlight(@RequestBody FlightRequest flightRequest) {
        return ResponseEntity.ok(flightService.createNewFlight(flightRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable("id") String id,
                                          @RequestBody FlightRequest flightRequest) {
        try {
            FlightResponse flightResponse = flightService.updateFlight(id,flightRequest);
            return ResponseEntity.ok(flightResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
