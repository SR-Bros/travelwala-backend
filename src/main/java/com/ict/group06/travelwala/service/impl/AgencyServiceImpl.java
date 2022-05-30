package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Agency;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.AgencyRequest;
import com.ict.group06.travelwala.model.response.AgencyResponse;
import com.ict.group06.travelwala.repository.AgencyRepository;
import com.ict.group06.travelwala.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    @Override
    public List<AgencyResponse> findAll() {
        return agencyRepository
                .findAll()
                .stream()
                .map(AgencyResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public AgencyResponse findById(String id) {
        Agency agency = agencyRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No agency found for id" + id));
        return new AgencyResponse(agency);
    }

    @Override
    public AgencyResponse createNewAgency(AgencyRequest agencyRequest) {
        Agency newAgency = new Agency(agencyRequest.getCode(), agencyRequest.getName(), agencyRequest.getChildPriceRate());
        return new AgencyResponse(agencyRepository.save(newAgency));
    }

    @Override
    public AgencyResponse updateAgency(String id, AgencyRequest agencyRequest) {
        Agency oldAgency = agencyRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No agency found for id" + id));

        oldAgency.setCode(agencyRequest.getCode());
        oldAgency.setName(agencyRequest.getName());
        oldAgency.setChildPriceRate(agencyRequest.getChildPriceRate());

        return new AgencyResponse(agencyRepository.save(oldAgency));
    }
}
