package com.ximena.todotask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ximena.todotask.dto.TaskResponseDto;
import com.ximena.todotask.model.Task;
import com.ximena.todotask.repository.TaskRepository;
import com.ximena.todotask.utils.converterDtoModels;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TaskService {
  @Autowired 
  private TaskRepository taskRepository;

  public Task createNewTask(Task task) {
    return taskRepository.save(task);
  }

  public List<TaskResponseDto> getAllTasks() {
    List<Task> tasks = taskRepository.findAllByOrderByIdAsc();
    List<TaskResponseDto> taskResponseDtos =  new ArrayList<>();

    for (Task t : tasks) {
      TaskResponseDto taskResponseDto = converterDtoModels.convertToDto(t);
      taskResponseDtos.add(taskResponseDto);
    }
    return taskResponseDtos;
  }

  public Task getTaskById(Long id) {
    return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe la tarea con id " + id));
  }

  public void deleteTask(Long id) {
    if (!taskRepository.existsById(id)) {
      throw new EntityNotFoundException("No existe la tarea con id " + id);
    }
    taskRepository.deleteById(id);
  }

  @Transactional
  public void updateStatusDone(Long id) {
    if (!taskRepository.existsById(id)) {
      throw new EntityNotFoundException("No existe la tarea con id " + id);
    }
    taskRepository.updateStatusDone(id);
  }

}
