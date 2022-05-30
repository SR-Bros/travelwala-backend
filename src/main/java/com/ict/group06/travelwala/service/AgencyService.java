package com.ict.group06.travelwala.service;

import com.ict.group06.travelwala.model.request.AgencyRequest;
import com.ict.group06.travelwala.model.response.AgencyResponse;

import java.util.List;

public interface AgencyService {
    List<AgencyResponse> findAll();
    AgencyResponse findById(String id);
    AgencyResponse createNewAgency(AgencyRequest agencyRequest);
    AgencyResponse updateAgency(String id, AgencyRequest agencyRequest);
}
