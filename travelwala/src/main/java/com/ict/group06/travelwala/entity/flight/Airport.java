package com.ict.group06.travelwala.entity.flight;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("airports")
@Getter
@NoArgsConstructor
public class Airport {
    @Id
    private String id;

    @Field("name")
    @Indexed(unique = true, name = "airport_name_unique")
    @Setter
    private String name;

    @Field("city")
    @Setter
    private String city;

    @Field("country")
    @Setter
    private String country;

    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }
}
