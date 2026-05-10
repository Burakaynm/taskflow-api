package com.burakay.taskflow.controller;

import com.burakay.taskflow.dto.TaskRequest;
import com.burakay.taskflow.dto.TaskResponse;
import com.burakay.taskflow.entity.TaskPriority;
import com.burakay.taskflow.entity.TaskStatus;
import com.burakay.taskflow.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getTasks(
            @RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false) TaskPriority priority
    ) {
        return taskService.getTasks(status, priority);
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createtask(@Valid @RequestBody TaskRequest request){
        return taskService.crateTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id,
                                   @Valid @RequestBody TaskRequest request){
        return taskService.updateTask(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
