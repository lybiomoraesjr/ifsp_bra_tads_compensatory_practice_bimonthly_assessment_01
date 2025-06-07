package com.example.demo.repository.jpa;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskJpaRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}