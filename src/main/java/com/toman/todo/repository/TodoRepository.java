package com.toman.todo.repository;

import com.toman.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<TodoItem, Long> {

	TodoItem getById(Long id);

	List<TodoItem> findAll();

}
