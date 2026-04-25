package com.example.baitap25_4_2026.service;


import com.example.baitap25_4_2026.model.dto.TodoDTO;
import com.example.baitap25_4_2026.model.entity.Todo;
import com.example.baitap25_4_2026.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    private Todo mapTodo(TodoDTO todoDTO) {
        return new Todo(
                todoDTO.getId(),
                todoDTO.getContent(),
                todoDTO.getDueDate(),
                todoDTO.getStatus(),
                todoDTO.getPriority()
        );
    }

    public void addToDo(TodoDTO todoDTO) {
        Todo todo = mapTodo(todoDTO);
        todoRepository.save(todo);
    }
}
