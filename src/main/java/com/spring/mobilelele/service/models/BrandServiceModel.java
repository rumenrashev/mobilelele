package com.spring.mobilelele.service.models;

import org.hibernate.validator.constraints.Length;

public class BrandServiceModel {

    private String name;

    public BrandServiceModel() {
    }

    public String getName() {
        return name;
    }

    public BrandServiceModel setName(String name) {
        this.name = name;
        return this;
    }
}
