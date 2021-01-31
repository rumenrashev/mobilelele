package com.spring.mobilelele.service.services.impl;

import com.spring.mobilelele.data.enitites.UserEntity;
import com.spring.mobilelele.data.repsotories.RoleRepository;
import com.spring.mobilelele.data.repsotories.UserRepository;
import com.spring.mobilelele.service.models.UserLoginServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserLoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserLoginService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = this.userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            UserEntity user = optionalUser.get();
            UserLoginServiceModel userLoginServiceModel = this.modelMapper.map(user, UserLoginServiceModel.class);
            userLoginServiceModel.setAuthorities(user.getRoles());
            return userLoginServiceModel;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
