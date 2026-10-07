package com.ximena.todotask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.todotask.model.Task;
import com.ximena.todotask.service.TaskService;

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
  public List<Task> getAllTasks() {
    return taskService.getAllTasks();
  }

  /**
   * Obtener una tarea por su id
   * @param id
   * @return una tarea
   */
  @GetMapping("/task/{id}")
  public Task getTaskById(@PathVariable Long id) {
    return taskService.getTaskById(id);
  }

  /**
   * Crear una nueva tarea
   * @param task
   * @return la tarea creada
   */
  @PostMapping("/task")
  public Task createNewTask(@RequestBody Task task) {
    return taskService.createNewTask(task);
  }

  /**
   * Eliminar una tarea por su id
   * @param id
   */
  @DeleteMapping("/task/{id}")
  public void deleteTask(@PathVariable Long id){
    taskService.deleteTask(id);
  }

  /**
   * Actualizar el estado de una tarea a "done" por su id
   * @param id
   */
  @PostMapping("/task/done/{id}")
  public void updateStatusDone(@PathVariable Long id) {
    taskService.updateStatusDone(id);
  }
}
