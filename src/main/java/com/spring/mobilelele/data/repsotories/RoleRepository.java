package com.spring.mobilelele.data.repsotories;

import com.spring.mobilelele.data.enitites.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    boolean existsByAuthority(String authority);

    Optional<RoleEntity> findByAuthority(String authority);

}
