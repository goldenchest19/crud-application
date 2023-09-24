package com.crudapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

/**
 * Класс-сущность, представляющий задачу.
 */
@Data
@Entity
public class Task {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private boolean isCompleted;
    private LocalDate creationDate;
    private String title;

}
