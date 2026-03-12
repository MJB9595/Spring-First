package com.example.demo.controller;

import com.example.demo.dto.CreateTodoRequest;
import com.example.demo.dto.TodoResponse;
import com.example.demo.dto.UpdateTodoRequest;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoResponse create(@RequestBody CreateTodoRequest request) {

        return todoService.create(request);
    }

    @GetMapping
    public List<TodoResponse> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoResponse findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PatchMapping("/{id}")
    public TodoResponse update(
            @PathVariable Long id,
            @RequestBody UpdateTodoRequest request
    ){
        return todoService.update(id, request);
    }


    @DeleteMapping
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
