package com.spring.mobilelele.service.models;

import com.spring.mobilelele.data.enitites.users.RoleEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public class UserLoginServiceModel implements UserDetails {

    private String username;
    private String password;
    private Set<RoleEntity> authorities;

    public UserLoginServiceModel() {
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }


    @Override
    public Set<RoleEntity> getAuthorities() {
        return authorities;
    }

    public UserLoginServiceModel setAuthorities(Set<RoleEntity> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
