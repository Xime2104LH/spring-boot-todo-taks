package com.ximena.todotask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ximena.todotask.dto.TaskRequestDto;
import com.ximena.todotask.dto.TaskResponseDto;
import com.ximena.todotask.exception.ResourceNotFoundException;
import com.ximena.todotask.model.Task;
import com.ximena.todotask.repository.TaskRepository;
import com.ximena.todotask.utils.converterDtoModels;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
  @Autowired 
  private TaskRepository taskRepository;

  public Task createNewTask(TaskRequestDto taskRequestDto) {
    return taskRepository.save(converterDtoModels.convertToEntity(taskRequestDto));
  }

  public List<TaskResponseDto> getAllTasks() {
    List<Task> tasks = taskRepository.findAllByOrderByIdAsc();
    List<TaskResponseDto> taskResponseDtos =  tasks.stream()
      .map(t -> converterDtoModels.convertToDto(t))
      .toList();

    return taskResponseDtos;
  }

  public TaskResponseDto getTaskById(Long id) {
    Task taskFounded = taskRepository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("No existe la tarea con id " + id));

    return converterDtoModels.convertToDto(taskFounded);
  }

  public void deleteTask(Long id) {
    if (!taskRepository.existsById(id)) {
      throw new ResourceNotFoundException("No existe la tarea con id " + id);
    }
    taskRepository.deleteById(id);
  }

  @Transactional
  public void updateStatusDone(Long id) {
    if (!taskRepository.existsById(id)) {
      throw new ResourceNotFoundException("No existe la tarea con id " + id);
    }
    taskRepository.updateStatusDone(id);
  }

}
