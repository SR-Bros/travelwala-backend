package com.ict.group06.travelwala.controller;

import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.AgencyRequest;
import com.ict.group06.travelwala.model.response.AgencyResponse;
import com.ict.group06.travelwala.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agencies")
@RequiredArgsConstructor
public class AgencyController {
    private final AgencyService agencyService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(agencyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(agencyService.findById(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> createNewAgency(@RequestBody AgencyRequest agencyRequest) {
        return ResponseEntity.ok(agencyService.createNewAgency(agencyRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAgency(@PathVariable("id") String id,
                                          @RequestBody AgencyRequest agencyRequest) {
        try {
            AgencyResponse agencyResponse = agencyService.updateAgency(id,agencyRequest);
            return ResponseEntity.ok(agencyResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
