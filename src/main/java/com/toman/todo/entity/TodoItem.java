package com.toman.todo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class TodoItem {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String objective;

	public TodoItem(String objective) {
		this.objective = objective;
	}
}
