package com.example.TodoList.Controller;

import com.example.TodoList.DTO.UserDemoDTO;
import com.example.TodoList.Model.UserDemo;
import com.example.TodoList.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserDemoController {
    UserService userService;

    public UserDemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {

        List<UserDemoDTO> userDemoDTOList = userService.getUsers();

        model.addAttribute("users", userDemoDTOList);
        return "users";
    }
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDemoDTO());
        return "create-user";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserDemoDTO userDemoDTO) {

        UserDemo userDemo = new UserDemo();
        userDemo.setName(userDemoDTO.getName());
        userDemo.setEmail(userDemoDTO.getEmail());

        userService.createUserDemo(userDemo);

        return "redirect:/users";
    }

//    @DeleteMapping
//
//    @PutMapping
}
