package com.example.TodoList.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks_demo")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public UserDemo getUser() {
        return user;
    }

    public void setUser(UserDemo user) {
        this.user = user;
    }

    @NotBlank(message = "Task must have a description")
    private String description;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_demo_id")
    private UserDemo user;
}
