package com.spring.mobilelele.service.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {

    @Length(min = 3, max = 10, message = "First name must be between 3 and 10 characters")
    private String firstName;

    @Length(min = 3, max = 10, message = "Last name must be between 3 and 10 characters")
    private String lastName;

    @Length(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
    private String username;

    @Length(min = 3, max = 10, message = "Password must be between 3 and 10 characters")
    private String password;

    @NotNull(message = "Role is required")
    private String role;

    public UserRegisterBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRegisterBindingModel setRole(String role) {
        this.role = role;
        return this;
    }
}
