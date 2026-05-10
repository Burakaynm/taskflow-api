package com.burakay.taskflow.repository;

import com.burakay.taskflow.entity.Task;
import com.burakay.taskflow.entity.TaskPriority;
import com.burakay.taskflow.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByPriority(TaskPriority priority);

    List<Task> findByStatusAndPriority(TaskStatus status, TaskPriority priority);
}