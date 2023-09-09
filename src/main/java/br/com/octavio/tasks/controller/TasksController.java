package br.com.octavio.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.octavio.tasks.entity.Tasks;
import br.com.octavio.tasks.services.TasksServices;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

	@Autowired
	private TasksServices tasksServices;

	@PostMapping
	public ResponseEntity<Tasks> createTasks(@RequestBody Tasks tasks) {
		Tasks newTask = tasksServices.createTasks(tasks);
		return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
	}

	@GetMapping
	public ResponseEntity<List<Tasks>> listAllTasks() {
		List<Tasks> allTasks = tasksServices.listAllTasks();
		return ResponseEntity.ok(allTasks);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> searchTasksById(@PathVariable Long id) {
		Tasks tasks = tasksServices.searchTasksById(id);
		if (tasks != null) {
			return ResponseEntity.ok(tasks);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("task not found");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tasks> updateTask(@PathVariable Long id, @RequestBody Tasks UpdatedTask){
		Tasks tasks = tasksServices.updateTask(id, UpdatedTask);
		if (tasks != null) {
			return ResponseEntity.ok(tasks);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "task not foun");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		tasksServices.deleteTask(id);
		return ResponseEntity.noContent().build();
		}
}
