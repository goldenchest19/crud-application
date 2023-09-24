package com.crudapplication.service.impl;

import com.crudapplication.entity.Task;
import com.crudapplication.repository.TaskRepository;
import com.crudapplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Реализация сервиса для управления задачами.
 */
@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    /**
     * Конструктор
     * @param taskRepository
     */
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Создает новую задачу с указанным заголовком и статусом выполнения.
     *
     * @param title       Описание задачи.
     * @param isCompleted Статус выполнения задачи.
     * @return Созданная задача.
     */
    @Override
    public Task createTask(String title, boolean isCompleted) {
        var task = mapTask(title, isCompleted);
        return taskRepository.save(task);
    }

    /**
     * Обновляет существующую задачу с указанным идентификатором новым заголовком и статусом выполнения.
     *
     * @param id          Идентификатор задачи для обновления.
     * @param title       Новое описание задачи.
     * @param isCompleted   Новый статус выполнения задачи.
     * @return Обновленная задача.
     */
    @Override
    public Task updateTask(Long id, String title, boolean isCompleted) {
        var task = mapTask(title, isCompleted);
        task.setId(id);
        return taskRepository.save(task);
    }

    /**
     * Получает задачу по ее идентификатору.
     *
     * @param id Идентификатор задачи.
     * @return Задача с указанным идентификатором.
     */
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    /**
     * Удаляет задачу с указанным идентификатором.
     *
     * @param id Идентификатор задачи для удаления.
     */
    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Вспомогательный метод для создания задачи на основе переданных данных.
     *
     * @param title       Описание задачи.
     * @param isCompleted Статус выполнения задачи.
     * @return Созданная задача.
     */
    private Task mapTask(String title, boolean isCompleted) {
        var task = new Task();
        task.setCompleted(isCompleted);
        task.setTitle(title);
        task.setCreationDate(LocalDate.now());
        return task;
    }
}
