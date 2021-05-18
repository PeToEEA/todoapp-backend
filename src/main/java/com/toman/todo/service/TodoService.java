package com.toman.todo.service;

import com.toman.todo.dto.TodoItemDto;
import com.toman.todo.entity.TodoItem;
import com.toman.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public List<TodoItem> retrieveAll() {
		return todoRepository.findAll();
	}

	public void saveOrUpdateItem(TodoItemDto todoItemDto) {
		if(todoItemDto.getId() != null) {
			TodoItem todoItem = todoRepository.getById(todoItemDto.getId());
			if(todoItem != null && !todoItem.getObjective().equals(todoItemDto.getObjective())) {
				todoItem.setObjective(todoItemDto.getObjective());
				todoRepository.save(todoItem);
				return;
			}
		}
		TodoItem todoItem = new TodoItem(todoItemDto.getObjective());
		todoRepository.save(todoItem);
	}

	public void deleteItem(Long id) {
		TodoItem todoItem = todoRepository.getById(id);
		if(todoItem != null) {
			todoRepository.delete(todoItem);
		}
	}

}
