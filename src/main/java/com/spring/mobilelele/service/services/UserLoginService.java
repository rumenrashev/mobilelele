package com.spring.mobilelele.service.services;

import com.spring.mobilelele.data.enitites.UserEntity;
import com.spring.mobilelele.data.repsotories.UserRepository;
import com.spring.mobilelele.service.models.UserLoginServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserLoginService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = this.userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            UserDetails userDetails = this.modelMapper.map(optionalUser.get(), UserLoginServiceModel.class);
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
