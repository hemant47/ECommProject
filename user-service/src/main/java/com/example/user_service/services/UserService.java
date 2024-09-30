package com.example.user_service.services;

import com.example.user_service.Repositry.RoleRepository;
import com.example.user_service.Repositry.UserRepository;
import com.example.user_service.models.Role;
import com.example.user_service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Set<Role> getUserRoles(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getRoles();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    // Additional methods for managing users
}