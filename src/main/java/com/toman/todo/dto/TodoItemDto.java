package com.toman.todo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter @Setter
public class TodoItemDto {

	@Nullable
	private Long id;

	@Nullable
	private String objective;

}
