package com.ximena.todotask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.todotask.dto.ApiResponse;
import com.ximena.todotask.dto.TaskRequestDto;
import com.ximena.todotask.dto.TaskResponseDto;
import com.ximena.todotask.model.Task;
import com.ximena.todotask.service.TaskService;

import jakarta.validation.Valid;

/** Operaciones sobre Tareas */
@RestController
@RequestMapping("/api/v1")
public class TaskController {

  @Autowired
  public TaskService taskService;

  /**
   * Obtener listado de todos las tareas
   *
   * @return listado de tareas
   */
  @GetMapping ("/tasks")
  public ResponseEntity<ApiResponse<List<TaskResponseDto>>>  getAllTasks() {
    List<TaskResponseDto> tasks = taskService.getAllTasks();
    return ResponseEntity.ok(ApiResponse.success("Listado de tareas", tasks));
  }

  /**
   * Obtener una tarea por su id
   * @param id
   * @return una tarea
   */
  @GetMapping("/task/{id}")
  public ResponseEntity<ApiResponse<TaskResponseDto>> getTaskById(@PathVariable Long id) {
    TaskResponseDto taskResponseDto = taskService.getTaskById(id);

    return ResponseEntity.ok(ApiResponse.success("Tarea encontrada exitosamente",  taskResponseDto));
  }

  /**
   * Crear una nueva tarea
   * @param task
   * @return la tarea creada
   */
  @PostMapping("/task")
  public ResponseEntity<ApiResponse<Task>> createNewTask(@Valid @RequestBody TaskRequestDto task) {
    Task newTask = taskService.createNewTask(task);
    return ResponseEntity.ok(ApiResponse.success("Tarea creada exitosamente", newTask));
  }

  /**
   * Eliminar una tarea por su id
   * @param id
   */
  @DeleteMapping("/task/{id}")
  public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable Long id){
    taskService.deleteTask(id);
    return ResponseEntity.ok(ApiResponse.success("Tarea eliminada exitosamente", null));
  }

  /**
   * Actualizar el estado de una tarea a "done" por su id
   * @param id
   */
  @PostMapping("/task/done/{id}")
  public ResponseEntity<ApiResponse<Void>> updateStatusDone(@PathVariable Long id) {
    taskService.updateStatusDone(id);
    return ResponseEntity.ok(ApiResponse.success("Tarea actualizada exitosamente", null));
  }
}
