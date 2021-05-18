package com.toman.todo.controller;

import com.toman.todo.dto.TodoItemDto;
import com.toman.todo.entity.TodoItem;
import com.toman.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoApiController {

	@Autowired
	TodoService todoService;

	@GetMapping("/todos")
	List<TodoItem> retrieveAllItems() {
		return todoService.retrieveAll();
	}

	@PostMapping("/todos")
	void saveNewItem(@RequestBody TodoItemDto todoItemDto) {
		todoService.saveOrUpdateItem(todoItemDto);
	}

	@DeleteMapping("/todos/{id}")
	void deleteItem(@PathVariable Long id) {
		todoService.deleteItem(id);
	}
}
