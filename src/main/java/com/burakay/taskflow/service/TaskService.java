package com.burakay.taskflow.service;

import com.burakay.taskflow.dto.TaskRequest;
import com.burakay.taskflow.dto.TaskResponse;
import com.burakay.taskflow.entity.Task;
import com.burakay.taskflow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.burakay.taskflow.exception.TaskNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskResponse> getAllTasks(){
        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TaskResponse getTaskById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return mapToResponse(task);
    }

    public TaskResponse crateTask(TaskRequest request){
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .priority(request.getPriority())
                .dueDate(request.getDueDate())
                .build();

        Task savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        Task updatedTask = taskRepository.save(task);

        return mapToResponse(updatedTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);        }

        taskRepository.deleteById(id);
    }

    private TaskResponse mapToResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .dueDate(task.getDueDate())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }

}
