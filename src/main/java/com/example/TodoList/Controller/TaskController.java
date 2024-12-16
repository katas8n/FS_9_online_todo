package com.example.TodoList.Controller;

import com.example.TodoList.DTO.TaskDTO;
import com.example.TodoList.Service.TaskService;
import com.example.TodoList.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;
    UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    //    Users tasks by ID
    @GetMapping("/users/{id}")
    public String usersTasks(@PathVariable Long id, Model model) {
        List<TaskDTO> tasks = taskService.findByUserId(id);
        model.addAttribute("tasks", tasks);
        model.addAttribute("user", id);

        return "user-tasks";
    }
    //    Create Tasks
//    @PostMapping
//    @DeleteMapping
//    @PutMapping
}
