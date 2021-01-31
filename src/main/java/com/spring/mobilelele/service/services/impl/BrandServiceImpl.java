package com.spring.mobilelele.service.services.impl;

import com.spring.mobilelele.data.enitites.BrandEntity;
import com.spring.mobilelele.data.repsotories.BrandRepository;
import com.spring.mobilelele.service.models.BrandServiceModel;
import com.spring.mobilelele.service.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addBrand(BrandServiceModel brandServiceModel) {
        if (this.brandRepository.existsByName(brandServiceModel.getName())) {
            return false;
        }
        BrandEntity brandEntity = this.modelMapper.map(brandServiceModel, BrandEntity.class);
        brandEntity
                .setCreated(Instant.now())
                .setModified(Instant.now());
        this.brandRepository.saveAndFlush(brandEntity);
        return true;
    }
}
