package com.example.TodoList.Service;

import com.example.TodoList.DTO.TaskDTO;
import com.example.TodoList.DTO.UserDemoDTO;
import com.example.TodoList.Model.UserDemo;
import com.example.TodoList.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public void createUserDemo(UserDemo userDemo) {
        this.userRepository.save(userDemo);
    }

    public List<UserDemoDTO> getUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDemoDTO userDemoDTO = new UserDemoDTO();
            userDemoDTO.setId(user.getId());
            userDemoDTO.setName(user.getName());
            userDemoDTO.setEmail(user.getEmail());

            return userDemoDTO;
        }).toList();
    }
}
