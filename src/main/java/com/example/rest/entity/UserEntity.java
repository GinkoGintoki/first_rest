package com.example.rest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<ToDoEntity> toDoEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoEntity> getToDoEntities() {
        return toDoEntities;
    }

    public void setToDoEntities(List<ToDoEntity> toDoEntities) {
        this.toDoEntities = toDoEntities;
    }
}
