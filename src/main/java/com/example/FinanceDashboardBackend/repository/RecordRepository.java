package com.example.financedashboardbackend.repository;

import com.example.financedashboardbackend.entity.Record;
import com.example.financedashboardbackend.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByCategoryAndType(String category, RecordType type);
}