package com.spring.mobilelele.data.enitites.cars;

import com.spring.mobilelele.data.enitites.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    private String name;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandEntity that = (BrandEntity) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Brand %n name : %s %n %s",
                this.getName(),
                super.toString());
    }
}
