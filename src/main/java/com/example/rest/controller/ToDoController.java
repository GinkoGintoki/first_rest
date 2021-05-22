package com.example.rest.controller;

import com.example.rest.entity.ToDoEntity;
import com.example.rest.service.ToDoService;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDoEntity,
                                     @RequestParam Long userId){
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDoEntity,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Get Error");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(toDoService.completeToDo(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Get Error");
        }
    }
}
