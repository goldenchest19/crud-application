package com.crudapplication.controller;

import com.crudapplication.dto.TaskDto;
import com.crudapplication.entity.Task;
import com.crudapplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления задачами.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Создает новую задачу с указанными данными.
     *
     * @param taskDto Данные задачи (включая описание и статус выполнения).
     * @return ResponseEntity
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        System.out.println("Создание задачи");
        var task = taskService.createTask(taskDto.getTitle(), taskDto.isCompleted());
        System.out.println("Задача создана");
        return ResponseEntity.ok(task);
    }

    /**
     * Обновляет существующую задачу с новыми данными.
     *
     * @param taskDto Данные задачи для обновления (включая идентификатор, описание и статус выполнения).
     * @return ResponseEntity, содержащий обновленную задачу.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task taskDto) {
        System.out.println("Обновление задачи с идентификатором: " + taskDto.getId());
        var task = taskService.updateTask(taskDto.getId(), taskDto.getTitle(), taskDto.isCompleted());
        System.out.println("Задача обновлена: " + task.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    /**
     * Получает задачу по ее идентификатору.
     *
     * @param id Идентификатор задачи, которую необходимо получить.
     * @return ResponseEntity, содержащий запрошенную задачу.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        System.out.println("Получение задачи с идентификатором: " + id);
        var task = taskService.getTaskById(id);
        System.out.println("Задача получена: " + task.getTitle());
        return ResponseEntity.ok(task);
    }

    /**
     * Удаляет задачу по ее идентификатору.
     *
     * @param id Идентификатор задачи, которую необходимо удалить.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable("id") Long id) {
        System.out.println("Удаление задачи с идентификатором: " + id);
        taskService.deleteTaskById(id);
        System.out.println("Задача удалена");
    }
}
