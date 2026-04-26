package com.example.baitap25_4_2026.service;

import com.example.baitap25_4_2026.model.dto.TodoDTO;
import com.example.baitap25_4_2026.model.entity.Todo;
import com.example.baitap25_4_2026.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<TodoDTO> findById(Long id) {
        return todoRepository.findById(id).map(todo -> new TodoDTO(
                todo.getId(),
                todo.getContent(),
                todo.getDueDate(),
                todo.getStatus(),
                todo.getPriority()
        ));
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

    public void updateTodo(TodoDTO todoDTO) {
        if (todoDTO.getId() == null) {
            throw new IllegalArgumentException("ID khong duoc null");
        }

        Todo todo = todoRepository.findById(todoDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Khong tim thay todo"));

        todo.setContent(todoDTO.getContent());
        todo.setDueDate(todoDTO.getDueDate());
        todo.setStatus(todoDTO.getStatus());
        todo.setPriority(todoDTO.getPriority());

        todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
