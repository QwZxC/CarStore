package com.example.carstore.domain.entity.task;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID uuid;
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 10)
    private TaskStatus status;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "attempts", nullable = false)
    private Integer attempts;

    @Column(name = "error_message", length = 300)
    private String errorMessage;

}
