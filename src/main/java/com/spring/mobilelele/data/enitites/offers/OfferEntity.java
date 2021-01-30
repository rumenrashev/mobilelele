package com.spring.mobilelele.data.enitites.offers;

import com.spring.mobilelele.data.enitites.base.BaseEntity;
import com.spring.mobilelele.data.enitites.base.BaseEntityWithImage;
import com.spring.mobilelele.data.enitites.cars.ModelEntity;
import com.spring.mobilelele.data.enitites.users.UserEntity;
import com.spring.mobilelele.data.enums.EngineEnum;
import com.spring.mobilelele.data.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntityWithImage {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated
    private EngineEnum engine;

    @Column
    private Integer mileage;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    @Column
    private Integer year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }


    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Description : %s %n engine: %s %n mileage: %d %n" +
                "price: %s transmission: %s %n year: %s %n model: %s %n seller : %s %n %s",
                this.getDescription().substring(10) + "...",
                this.getEngine(),
                this.getMileage(),
                this.getPrice(),
                this.getTransmission(),
                this.getYear(),
                this.getModel().getName(),
                this.seller.getUsername(),
                super.toString());
    }
}
