package com.example.rest.repository;

import com.example.rest.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity,Long> {
}
