package com.burakay.taskflow.dto;

import com.burakay.taskflow.entity.TaskPriority;
import com.burakay.taskflow.entity.TaskStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class TaskResponse {

    private Long id;

    private  String title;

    private  String description;

    private TaskStatus status;

    private TaskPriority priority;

    private LocalDate dueDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
