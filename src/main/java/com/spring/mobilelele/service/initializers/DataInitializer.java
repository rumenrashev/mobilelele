package com.spring.mobilelele.service.initializers;

import com.spring.mobilelele.data.enitites.BrandEntity;
import com.spring.mobilelele.data.enitites.ModelEntity;
import com.spring.mobilelele.data.enitites.OfferEntity;
import com.spring.mobilelele.data.enitites.RoleEntity;
import com.spring.mobilelele.data.enitites.UserEntity;
import com.spring.mobilelele.data.enums.CategoryEnum;
import com.spring.mobilelele.data.enums.EngineEnum;
import com.spring.mobilelele.data.enums.RoleNameEnum;
import com.spring.mobilelele.data.enums.TransmissionEnum;
import com.spring.mobilelele.data.repsotories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, BrandRepository brandRepository, ModelRepository modelRepository, OfferRepository offerRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedRolesToDB();
//        List<RoleEntity> adminRoles = this.roleRepository.findAll();
//        RoleEntity userRole = this.roleRepository.findByAuthority(RoleNameEnum.USER_ROLE.name())
//                .orElseThrow(Exception::new);
//        UserEntity admin = this.createUser("admin", "Asen",
//                "Asenov", new LinkedHashSet<>(adminRoles));
//        UserEntity user = this.createUser("user", "Boris",
//                "Borisov", Set.of(userRole));
//        BrandEntity brand = this.createBrand("Mercedes-Benz");
//        ModelEntity model = this.createModel("E-class", CategoryEnum.CAR, 1970, null, brand);
//        OfferEntity offer = createOffer("Just a car", EngineEnum.DIESEL, 100000, new BigDecimal(10000)
//                , TransmissionEnum.AUTOMATIC, 2000, model, user);


    }

    private void seedRolesToDB() {
        EnumSet.allOf(RoleNameEnum.class)
                .stream()
                .map(RoleNameEnum::name)
                .filter(r -> !roleRepository.existsByAuthority(r))
                .map(r -> {
                    RoleEntity roleEntity = new RoleEntity();
                    roleEntity
                            .setAuthority(r)
                            .setCreated(Instant.now())
                            .setModified(Instant.now());
                    return roleEntity;
                })
                .forEach(roleRepository::save);
    }


    private UserEntity createUser(String username, String firstName,
                                  String lastName, Set<RoleEntity> authorities) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        UserEntity user = new UserEntity();
        user
                .setUsername(username)
                .setPassword("password")
                .setFirstName(firstName)
                .setLastName(lastName)
                .setActive(true)
                .setRoles(authorities)
                .setImageUrl("https://simpleicon.com/wp-content/uploads/user1.png")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.userRepository.saveAndFlush(user);

    }

    private BrandEntity createBrand(String name) {
        Optional<BrandEntity> optionalBrand = brandRepository.findByName(name);
        if (optionalBrand.isPresent()){
            return optionalBrand.get();
        }
        BrandEntity brand = new BrandEntity();
        brand.setName(name)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.brandRepository.saveAndFlush(brand);
    }

    private ModelEntity createModel(String name, CategoryEnum category , Integer startYear ,
                                    Integer endYear,BrandEntity brand){
        Optional<ModelEntity> optionalModel = this.modelRepository.findByName(name);
        if (optionalModel.isPresent()){
            return optionalModel.get();
        }
        ModelEntity model = new ModelEntity();
        model
                .setName(name)
                .setCategory(category)
                .setStartYear(startYear)
                .setEndYear(endYear)
                .setBrand(brand)
                .setImageUrl("https://wsa1.pakwheels.com/assets/default-display-image-car-638815e7606c67291ff77fd17e1dbb16.png")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.modelRepository.saveAndFlush(model);
    }

    private OfferEntity createOffer(String description, EngineEnum engine, Integer mileage,
                                    BigDecimal price, TransmissionEnum transmission,Integer year,
                                    ModelEntity model,UserEntity seller){
        OfferEntity offer = new OfferEntity();
        offer
                .setDescription(description)
                .setEngine(engine)
                .setPrice(price)
                .setTransmission(transmission)
                .setYear(year)
                .setMileage(mileage)
                .setModel(model)
                .setSeller(seller)
                .setImageUrl(model.getImageUrl())
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return offerRepository.count() == 0 ? offerRepository.saveAndFlush(offer) : null;
    }
}
