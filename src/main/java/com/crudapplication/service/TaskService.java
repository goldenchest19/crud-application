package com.crudapplication.service;

import com.crudapplication.entity.Task;

/**
 * Интерфейс сервиса для управления задачами.
 */
public interface TaskService {

    /**
     * Создает новую задачу с указанным заголовком и статусом выполнения.
     *
     * @param title       Описание задачи.
     * @param isCompleted Статус выполнения задачи.
     * @return Созданная задача.
     */
    Task createTask(String title, boolean isCompleted);

    /**
     * Обновляет существующую задачу с указанным идентификатором новым заголовком и статусом выполнения.
     *
     * @param id        Идентификатор задачи для обновления.
     * @param title     Новое описание задачи.
     * @param completed Новый статус выполнения задачи.
     * @return Обновленная задача.
     */
    Task updateTask(Long id, String title, boolean completed);

    /**
     * Получает задачу по ее идентификатору.
     *
     * @param id Идентификатор задачи.
     * @return Задача с указанным идентификатором.
     */
    Task getTaskById(Long id);

    /**
     * Удаляет задачу с указанным идентификатором.
     *
     * @param id Идентификатор задачи для удаления.
     */
    void deleteTaskById(Long id);
}
