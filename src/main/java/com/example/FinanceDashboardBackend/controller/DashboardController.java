package com.example.financedashboardbackend.controller;

import com.example.financedashboardbackend.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public Map<String, Object> summary() {
        return service.getSummary();
    }
}