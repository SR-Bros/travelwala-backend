package com.ict.group06.travelwala.model.response;

import com.ict.group06.travelwala.entity.flight.Agency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyResponse {
    private String id;
    private String code;
    private String name;
    private Double childPriceRate;

    public AgencyResponse(Agency agency) {
        this(agency.getId(), agency.getCode(), agency.getName(), agency.getChildPriceRate());
    }
}
