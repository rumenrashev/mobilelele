package com.spring.mobilelele.data.enitites.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntityWithImage extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String imageUrl;


    protected BaseEntityWithImage(){

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BaseEntityWithImage setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return String.format("image url: %s %n %s",
                this.getImageUrl(),
                super.toString());
    }
}
