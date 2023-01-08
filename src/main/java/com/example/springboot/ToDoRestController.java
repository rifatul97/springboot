package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController("/todo")
public class ToDoRestController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/all")
    public List<ToDo> findAllUsers() {
        return (List<ToDo>) toDoRepository.findAll();
    }

    @GetMapping("/save")
    public ToDo saveUser() {
        System.out.println("saving him:");
        ToDo toDo = new ToDo();
        toDo.setId(1L);
        toDo.setComplete(false);
        toDo.setInsertedAt(Timestamp.from(Instant.now()));
        toDo.setTask("test databse");
        toDo.setUserId(UUID.randomUUID());

        toDoRepository.save(toDo);
        return toDo;
    }

}