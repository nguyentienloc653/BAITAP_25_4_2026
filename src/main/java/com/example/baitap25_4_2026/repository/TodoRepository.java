package com.example.baitap25_4_2026.repository;

import com.example.baitap25_4_2026.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Long id(Long id);
}
