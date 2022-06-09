package com.ict.group06.travelwala.model.response;

import com.ict.group06.travelwala.entity.flight.Plane;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaneResponse {
    private String id;
    private String manufacturer;
    private String code;
    private String name;
    private Integer maximumEconomicCapacity;
    private Integer maximumBusinessCapacity;

    public PlaneResponse(Plane plane) {
        this.id = plane.getId();
        this.manufacturer = plane.getManufacturer();
        this.code = plane.getCode();
        this.name = plane.getManufacturer().concat(" ").concat(this.code);
        this.maximumEconomicCapacity = plane.getMaximumEconomicCapacity();
        this.maximumBusinessCapacity = plane.getMaximumBusinessCapacity();
    }
}
