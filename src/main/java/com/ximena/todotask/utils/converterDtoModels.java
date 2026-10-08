package com.ximena.todotask.utils;

import com.ximena.todotask.dto.TaskResponseDto;
import com.ximena.todotask.model.Task;

public class converterDtoModels {

  public static TaskResponseDto convertToDto(Task task) {
    TaskResponseDto dto = new TaskResponseDto(task.getId(), task.getTitle(), task.getDone(), task.getPriority());
    return dto;
  }

  public static Task convertToEntity(TaskResponseDto dto) {
    Task task = new Task(dto.getId(), dto.getTitle(), dto.getDone(), dto.getPriority());
    return task;
  }

}
