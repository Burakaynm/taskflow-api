package com.burakay.taskflow.dto;

import com.burakay.taskflow.entity.TaskPriority;
import com.burakay.taskflow.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    @NotBlank(message = "Title cannot be empty")
    @Size(max = 255,message = "Title cannot exceed 255 characters")
    private String title;

    @Size(max = 1000,message = "Description cannot exceed 1000 characters")
    private String description;

    private TaskStatus status;

    private TaskPriority priority;

    private LocalDate dueDate;
}
