package com.spring.mobilelele.service.models;

public class UserRegisterServiceModel {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;

    public UserRegisterServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRegisterServiceModel setRole(String role) {
        this.role = role;
        return this;
    }
}
