package com.spring.mobilelele.data.repsotories;

import com.spring.mobilelele.data.enitites.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {
    boolean existsByName(String name);

    Optional<ModelEntity> findByName(String name);

}
