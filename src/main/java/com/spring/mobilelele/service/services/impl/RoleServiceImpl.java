package com.spring.mobilelele.service.services.impl;

import com.spring.mobilelele.data.enitites.users.RoleEntity;
import com.spring.mobilelele.data.enums.RoleNameEnum;
import com.spring.mobilelele.data.repsotories.RoleRepository;
import com.spring.mobilelele.service.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.EnumSet;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
