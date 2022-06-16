package com.ict.group06.travelwala.controller;

import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.AirlineRequest;
import com.ict.group06.travelwala.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {
    private final AirlineService airlineService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(airlineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(airlineService.findById(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> createNewAirline(@RequestBody AirlineRequest airlineRequest) {
        return ResponseEntity.ok(airlineService.createNewAirline(airlineRequest));
    }
}
