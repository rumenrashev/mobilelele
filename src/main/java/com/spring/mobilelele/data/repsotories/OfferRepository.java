package com.spring.mobilelele.data.repsotories;

import com.spring.mobilelele.data.enitites.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {

}
