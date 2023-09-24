package com.crudapplication.repository;

import com.crudapplication.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс репозитория для управления задачами.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
