package com.example.TodoList.Service;

import com.example.TodoList.DTO.TaskDTO;
import com.example.TodoList.Model.UserDemo;
import com.example.TodoList.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> findByUserId(Long userid) {
        return this.taskRepository.findByUserId(userid).stream().map(task -> {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setCompleted(task.isCompleted());

            return taskDTO;
        }).toList();
    }
}
