package com.example.financedashboardbackend.service;

import com.example.financedashboardbackend.entity.Record;
import com.example.financedashboardbackend.entity.RecordType;
import com.example.financedashboardbackend.repository.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private RecordRepository repo;

    public Map<String, Object> getSummary() {

        List<Record> records = repo.findAll();

        double income = records.stream()
                .filter(r -> r.getType() == RecordType.INCOME)
                .mapToDouble(Record::getAmount)
                .sum();

        double expense = records.stream()
                .filter(r -> r.getType() == RecordType.EXPENSE)
                .mapToDouble(Record::getAmount)
                .sum();

        Map<String, Double> categoryTotals = records.stream()
                .collect(Collectors.groupingBy(
                        Record::getCategory,
                        Collectors.summingDouble(Record::getAmount)
                ));

        Map<String, Object> res = new HashMap<>();
        res.put("totalIncome", income);
        res.put("totalExpense", expense);
        res.put("netBalance", income - expense);
        res.put("categoryTotals", categoryTotals);
        res.put("recent", records.stream().limit(5).toList());

        return res;
    }
}