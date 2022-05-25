package com.ict.group06.travelwala.entity.flight;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "agencies")
@Getter
@NoArgsConstructor
public class Agency {
    @Id
    private String id;

    @Field("code")
    @Indexed(unique = true, name = "agency_code_unique")
    @Setter
    private String code;

    @Field("name")
    @Setter
    private String name;

    @Field("child_price_rate")
    @Setter
    private Double childPriceRate;

    public Agency(String code, String name, Double childPriceRate) {
        this.code = code;
        this.name = name;
        this.childPriceRate = childPriceRate;
    }

    public Agency(String name, Double childPriceRate) {
        this.name = name;
        this.childPriceRate = childPriceRate;
    }
}
