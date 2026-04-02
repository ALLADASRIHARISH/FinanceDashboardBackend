package com.example.financedashboardbackend.service;

import com.example.financedashboardbackend.entity.Record;
import com.example.financedashboardbackend.entity.RecordType;
import com.example.financedashboardbackend.repository.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repo;

    // ✅ CREATE
    public Record create(Record r) {
        return repo.save(r);
    }

    // ✅ GET ALL (Pagination)
    public Page<Record> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    // ✅ FILTER (FIXED)
    public List<Record> filter(String category, RecordType type) {
        return repo.findByCategoryAndType(category, type);
    }

    // ✅ UPDATE
    public Record update(Long id, Record updated) {
        Record r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));

        if (updated.getAmount() != null) r.setAmount(updated.getAmount());
        if (updated.getCategory() != null) r.setCategory(updated.getCategory());
        if (updated.getType() != null) r.setType(updated.getType());
        if (updated.getDate() != null) r.setDate(updated.getDate());
        if (updated.getNotes() != null) r.setNotes(updated.getNotes());

        return repo.save(r);
    }

    // ✅ DELETE
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Record not found with id: " + id);
        }
        repo.deleteById(id);
    }
}