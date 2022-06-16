package com.ict.group06.travelwala.model.response;

import com.ict.group06.travelwala.entity.flight.Airline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineResponse {
    private String id;
    private String name;
    private String alias;
    private String iata;
    private String icao;
    private String callSign;
    private String country;
    private Boolean active;
    private Double childPriceRate;

    public AirlineResponse(Airline airline) {
        this(airline.getId(), airline.getName(), airline.getAlias(),
            airline.getIata(), airline.getIcao(), airline.getCallSign(),
            airline.getCountry(), airline.isActive(), airline.getChildPriceRate());
    }
}
