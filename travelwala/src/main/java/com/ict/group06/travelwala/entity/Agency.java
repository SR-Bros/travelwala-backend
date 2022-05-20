package com.ict.group06.travelwala.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "agencies")
@Data
public class Agency {
    @Id
    private String id;
    private String code;
    private String name;
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
