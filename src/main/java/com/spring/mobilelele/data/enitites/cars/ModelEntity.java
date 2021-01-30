package com.spring.mobilelele.data.enitites.cars;

import com.spring.mobilelele.data.enitites.base.BaseEntity;
import com.spring.mobilelele.data.enitites.base.BaseEntityWithImage;
import com.spring.mobilelele.data.enums.CategoryEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntityWithImage {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(nullable = false)
    private Integer startYear;

    @Column
    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;

    public ModelEntity() {
    }

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelEntity model = (ModelEntity) o;
        return name.equals(model.name) &&
                brand.equals(model.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand);
    }

    @Override
    public String toString() {
        return String.format("Model %n name : %s %n category: %s " +
                        "%n startYear: %d %n endYear: %d %n Brand : %s %n %s ",
                this.getName(),
                this.getCategory(),
//                this.getImageUrl(),
                this.getStartYear(),
                this.getEndYear(),
                this.getBrand().getName(),
                super.toString());
    }
}
