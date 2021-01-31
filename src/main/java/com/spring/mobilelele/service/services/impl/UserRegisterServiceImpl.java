package com.spring.mobilelele.service.services.impl;

import com.spring.mobilelele.data.enitites.RoleEntity;
import com.spring.mobilelele.data.enitites.UserEntity;
import com.spring.mobilelele.data.repsotories.RoleRepository;
import com.spring.mobilelele.data.repsotories.UserRepository;
import com.spring.mobilelele.service.models.UserRegisterServiceModel;
import com.spring.mobilelele.service.services.UserRegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserRegisterServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean registerUser(UserRegisterServiceModel user) {
        String username = user.getUsername();
        if (this.userRepository.existsByUsername(username)){
            return false;
        }
        RoleEntity roleEntity = roleRepository.findByAuthority(user.getRole()).get();
        UserEntity userEntity = this.modelMapper.map(user, UserEntity.class);
        userEntity
                .setPassword(this.passwordEncoder.encode(userEntity.getPassword()))
                .setRoles(Set.of(roleEntity))
                .setActive(true)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        this.userRepository.saveAndFlush(userEntity);
        return true;
    }
}
