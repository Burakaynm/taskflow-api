package com.burakay.taskflow.repository;

import com.burakay.taskflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
