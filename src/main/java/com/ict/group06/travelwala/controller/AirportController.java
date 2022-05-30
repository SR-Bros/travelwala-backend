package com.ict.group06.travelwala.controller;

import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.AirportRequest;
import com.ict.group06.travelwala.model.response.AirportResponse;
import com.ict.group06.travelwala.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(airportService.findById(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> createNewAirport(@RequestBody AirportRequest airportRequest) {
        return ResponseEntity.ok(airportService.createNewAirport(airportRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAirport(@PathVariable("id") String id,
                                          @RequestBody AirportRequest airportRequest) {
        try {
            AirportResponse airportResponse = airportService.updateAirport(id, airportRequest);
            return ResponseEntity.ok(airportResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
