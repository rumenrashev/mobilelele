package com.spring.mobilelele.data.repsotories;

import com.spring.mobilelele.data.enitites.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

    Optional<BrandEntity> findByName(String name);

    boolean existsByName(String name);
}
