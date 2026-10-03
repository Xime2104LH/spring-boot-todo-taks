package com.ximena.todotask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ximena.todotask.model.Task;

public interface TaskRepository  extends JpaRepository<Task, Long> {

  
  

}
