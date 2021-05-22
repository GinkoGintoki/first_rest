package com.example.rest.service;

import com.example.rest.entity.ToDoEntity;
import com.example.rest.entity.UserEntity;
import com.example.rest.model.ToDo;
import com.example.rest.repository.ToDoRepo;
import com.example.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final UserRepo userRepo;

    private final ToDoRepo toDoRepo;

    public ToDoService(UserRepo userRepo, ToDoRepo toDoRepo) {
        this.userRepo = userRepo;
        this.toDoRepo = toDoRepo;
    }

    public ToDo createToDo(ToDoEntity toDoEntity, Long userId){
        UserEntity user = userRepo.findById(userId).get();

        toDoEntity.setUser(user);
        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }

    public ToDo completeToDo(Long id){
        ToDoEntity toDoEntity = toDoRepo.findById(id).get();
        toDoEntity.setCompleted(!toDoEntity.getCompleted());
        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }
}
