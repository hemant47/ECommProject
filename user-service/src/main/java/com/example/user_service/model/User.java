package com.example.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "ECOM_USER")
@Getter
@Setter
public class User extends BaseModel {
    private String email;
    private String password;
    @ManyToMany
    private Set<com.example.user_service.model.Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return null;
    }
}