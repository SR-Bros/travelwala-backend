package com.ict.group06.travelwala.entity.flight;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "planes")
@Getter
@NoArgsConstructor
public class Plane {
    @Id
    private String id;

    @Field("manufacturer")
    @Setter
    private String manufacturer;

    @Field("code")
    @Indexed(unique = true, name = "plane_code_unique")
    @Setter
    private String code;

    @Field("maximum_economic_capacity")
    @Setter
    private Integer maximumEconomicCapacity;

    @Field("maximum_business_capacity")
    @Setter
    private Integer maximumBusinessCapacity;

    public Plane(String manufacturer, String code, Integer maximumBusinessCapacity, Integer maximumEconomicCapacity) {
        this.manufacturer = manufacturer;
        this.code = code;
        this.maximumEconomicCapacity = maximumEconomicCapacity;
        this.maximumBusinessCapacity = maximumBusinessCapacity;
    }

    public String getName() {
        return this.manufacturer.concat(this.code);
    }
}
