package com.toman.todo;

import com.toman.todo.entity.TodoItem;
import com.toman.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoRepository todoRepository) {
		return (args) -> {

			List<TodoItem> timeSlots = todoRepository.findAll();
			if(timeSlots.size() < 5) {
				TodoItem td1 = new TodoItem("odovzdat projekt");
				todoRepository.save(td1);

				TodoItem td2 = new TodoItem("kupit vodu do ostrekovacov");
				todoRepository.save(td2);

				TodoItem td3 = new TodoItem("kupit chleba");
				todoRepository.save(td3);

				TodoItem td4 = new TodoItem("nieco ine");
				todoRepository.save(td4);

				TodoItem td5 = new TodoItem("a cosi dalsie");
				todoRepository.save(td5);
			}

		};
	}

}
