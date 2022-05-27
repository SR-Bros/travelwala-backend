package com.ict.group06.travelwala.controller;

import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.request.FlightRequest;
import com.ict.group06.travelwala.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/")
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

    @PostMapping("/{id}")
    public ResponseEntity<?> createNewFlight(@PathVariable("id") String id,
                                          @RequestBody FlightRequest flightRequest) {
        return ResponseEntity.ok(flightService.createNewFlight(flightRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable("id") String id,
                                          @RequestBody FlightRequest flightRequest) {
        return ResponseEntity.ok(flightService.updateFlight(id, flightRequest));
    }
}
