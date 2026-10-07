package com.ximena.todotask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ximena.todotask.model.Task;

import jakarta.transaction.Transactional;

public interface TaskRepository  extends JpaRepository<Task, Long> {

  List<Task> findByTitleContainingIgnoreCase(String title);

  List<Task> findAllByOrderByIdAsc();
  //ByOrderByIdAsc

  @Transactional 
  @Modifying 
  @Query("UPDATE Task t SET t.done = CASE WHEN t.done = true THEN false ELSE true END WHERE t.id = :id")
  void updateStatusDone(Long id);

}

// public interface ProductRepository extends JpaRepository<Product, Long> {
//   @Query(value = "SELECT * FROM product_inventory WHERE product_name = ?1", nativeQuery = true)
//   List<Product> getProductsByName(String productName);
// }