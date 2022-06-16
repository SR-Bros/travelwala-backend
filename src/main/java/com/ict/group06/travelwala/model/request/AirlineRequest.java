package com.ict.group06.travelwala.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineRequest {
    private String name;
    private String alias;
    private String iata;
    private String icao;
    private String callSign;
    private String country;
    private Boolean active;
    private Double childPriceRate;
}
