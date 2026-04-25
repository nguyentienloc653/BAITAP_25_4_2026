package com.example.baitap25_4_2026.controller;


import com.example.baitap25_4_2026.model.dto.TodoDTO;
import com.example.baitap25_4_2026.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "todos";
    }

    @GetMapping("/add-todo")
    public String showAddTodo(Model model) {
        model.addAttribute("todo", new TodoDTO());
        return "todoForm";
    }

    @PostMapping("/add-todo")
    public String addTodo(@Valid @ModelAttribute("todo") TodoDTO todoDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todoForm";
        }
        todoService.addToDo(todoDTO);
        return "redirect:/todos";
    }
}
