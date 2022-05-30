package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyRequest {
    private String code;
    private String name;
    private Double childPriceRate;
}
