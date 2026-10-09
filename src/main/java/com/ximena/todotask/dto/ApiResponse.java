package com.ximena.todotask.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude (JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(String status, String message, T data, Object errors) {
  public static <T> ApiResponse<T> success(String message, T data) {
    return new ApiResponse<>("success", message, data, null);
  }

  public static <T> ApiResponse<T> error(String message) {
    return new ApiResponse<>("error", message, null, null);
  }

  public static <T> ApiResponse<T> error(String message, Object errors) {
    return new ApiResponse<>("error", message, null, errors);
  }
}


