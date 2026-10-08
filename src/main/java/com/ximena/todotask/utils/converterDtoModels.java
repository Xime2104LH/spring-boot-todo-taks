package com.ximena.todotask.utils;

import com.ximena.todotask.dto.TaskRequestDto;
import com.ximena.todotask.dto.TaskResponseDto;
import com.ximena.todotask.model.Task;

public class converterDtoModels {

  public static TaskResponseDto convertToDto(Task task) {
    TaskResponseDto dto = new TaskResponseDto(task.getId(), task.getTitle(), task.getDone(), task.getPriority());
    return dto;
  }

  public static Task convertToEntity(TaskRequestDto dto) {
    Task task = new Task(null, dto.getTitle(), dto.getDone(), dto.getPriority());
    return task;
  }

}
