package com.crudapplication.dto;

import lombok.Data;

/**
 * Объект передачи данных (DTO) для представления задачи.
 */
@Data
public class TaskDto {
    private Long id;
    private String title;
    private boolean completed;
}
