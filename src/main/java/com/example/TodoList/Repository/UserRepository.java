package com.example.TodoList.Repository;

import com.example.TodoList.Model.Task;
import com.example.TodoList.Model.UserDemo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDemo, Long> {
}
