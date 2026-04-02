package com.example.financedashboardbackend.service;

import com.example.financedashboardbackend.entity.Role;
import com.example.financedashboardbackend.entity.User;
import com.example.financedashboardbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // ✅ CREATE USER
    public User create(User user) {
        return repo.save(user);
    }

    // ✅ GET ALL USERS
    public List<User> getAll() {
        return repo.findAll();
    }

    // ✅ UPDATE ROLE / STATUS
    public User update(Long id, Role role, Boolean active) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (role != null) user.setRole(role);
        if (active != null) user.setActive(active);

        return repo.save(user);
    }

    // ✅ DELETE USER
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        repo.deleteById(id);
    }
}