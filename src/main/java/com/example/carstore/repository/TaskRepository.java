package com.example.carstore.repository;

import com.example.carstore.domain.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task , UUID> {
}
