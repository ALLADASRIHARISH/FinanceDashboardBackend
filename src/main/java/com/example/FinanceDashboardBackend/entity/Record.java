package com.example.financedashboardbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Double amount;

    @Enumerated(EnumType.STRING)
    private RecordType type;

    @NotBlank
    private String category;

    private LocalDate date;

    private String notes;

    // ✅ GETTERS

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public RecordType getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    // ✅ SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}