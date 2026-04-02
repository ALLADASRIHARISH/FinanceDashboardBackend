package com.example.financedashboardbackend.controller;

import com.example.financedashboardbackend.entity.Record;
import com.example.financedashboardbackend.entity.RecordType;
import com.example.financedashboardbackend.service.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping
    public Record create(@RequestBody Record r) {
        return service.create(r);
    }

    @GetMapping
    public Page<Record> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/filter")
    public List<Record> filter(@RequestParam String category,
                               @RequestParam RecordType type) {
        return service.filter(category, type);
    }

    @PatchMapping("/{id}")
    public Record update(@PathVariable Long id,
                         @RequestBody Record r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}