package com.ximena.todotask.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {

  @NotEmpty(message = "El título no puede estar vacío")
  @Size(min = 5, max = 100, message = "El título debe tener entre 5 y 100 caracteres")
  private String title;

  @NotNull(message = "El estado no puede ser nulo")
  private Boolean done;

  @NotNull(message = "La prioridad no puede ser nula")
  @Positive
  @Max(value = 3, message = "La prioridad debe ser un número positivo entre 1 y 3")
  private Integer priority;

}
