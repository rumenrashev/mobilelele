package com.spring.mobilelele.data.repsotories;

import com.spring.mobilelele.data.enitites.cars.ModelEntity;
import com.spring.mobilelele.data.enitites.offers.OfferEntity;
import com.spring.mobilelele.data.enitites.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {

}
