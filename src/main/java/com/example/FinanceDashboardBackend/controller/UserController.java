package com.example.financedashboardbackend.controller;

import com.example.financedashboardbackend.entity.User;
import com.example.financedashboardbackend.entity.Role;
import com.example.financedashboardbackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestParam(required = false) Role role,
                       @RequestParam(required = false) Boolean active) {
        return service.update(id, role, active);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}