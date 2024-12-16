package com.example.TodoList.Repository;

import com.example.TodoList.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
//    SELECT * FROM task WHERE id = id
    List<Task> findByUserId (Long id);

}
