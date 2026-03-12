package com.example.demo.dto;

import com.example.demo.domain.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {
    private long id;
    private String title;
    private String content;
    private boolean completed;

    public TodoResponse(Todo todo) {
        this.id= todo.getId();
        this.title= todo.getTitle();
        this.content=todo.getContent();
        this.completed=todo.isCompleted();
    }
}
