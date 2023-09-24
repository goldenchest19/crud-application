package com.crudapplication;

import com.crudapplication.controller.TaskController;
import com.crudapplication.dto.TaskDto;
import com.crudapplication.entity.Task;
import com.crudapplication.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Класс, содержащий юнит-тесты для класса TaskController.
 */
public class TaskControllerTest {

    @Mock
    private TaskService taskService;

    private TaskController taskController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        taskController = new TaskController(taskService);
    }

    /**
     * Тест для метода createTask контроллера.
     */
    @Test
    public void testCreateTask() {
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle("Test Task");
        taskDto.setCompleted(false);

        Task createdTask = new Task();
        createdTask.setId(1L);
        createdTask.setTitle(taskDto.getTitle());
        createdTask.setCompleted(taskDto.isCompleted());

        when(taskService.createTask(taskDto.getTitle(), taskDto.isCompleted())).thenReturn(createdTask);

        ResponseEntity<Task> response = taskController.createTask(taskDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(createdTask, response.getBody());
    }

    /**
     * Тест для метода updateTask контроллера.
     */
    @Test
    public void testUpdateTask() {
        Task updatedTask = new Task();
        updatedTask.setId(1L);
        updatedTask.setTitle("Updated Task");
        updatedTask.setCompleted(true);

        when(taskService.updateTask(updatedTask.getId(), updatedTask.getTitle(), updatedTask.isCompleted())).thenReturn(updatedTask);

        ResponseEntity<Task> response = taskController.updateTask(updatedTask);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(updatedTask, response.getBody());
    }

    /**
     * Тест для метода getTaskById контроллера.
     */
    @Test
    public void testGetTaskById() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Test Task");
        task.setCompleted(false);

        when(taskService.getTaskById(taskId)).thenReturn(task);

        ResponseEntity<Task> response = taskController.getTaskById(taskId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(task, response.getBody());
    }

    /**
     * Тест для метода deleteTaskById контроллера.
     */
    @Test
    public void testDeleteTaskById() {
        Long taskId = 1L;

        // Mock the service call to delete the task
        doNothing().when(taskService).deleteTaskById(taskId);

        // Call the controller method to delete the task
        taskController.deleteTaskById(taskId);

        // Verify that the service method was called
        verify(taskService, times(1)).deleteTaskById(taskId);
    }
}
