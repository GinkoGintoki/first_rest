package com.example.rest.model;

import com.example.rest.entity.ToDoEntity;
import com.example.rest.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<ToDo> toDos;

    public User() {
    }

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setToDos(entity.getToDoEntities().stream().map(ToDo::toModel).collect(Collectors.toList()));
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }
}
