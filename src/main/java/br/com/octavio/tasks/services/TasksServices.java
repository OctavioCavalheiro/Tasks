package br.com.octavio.tasks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import br.com.octavio.tasks.entity.Tasks;
import br.com.octavio.tasks.repository.TasksRepository;

@Service
public class TasksServices {

	@Autowired
	private TasksRepository tasksRepository;
	
	public Tasks createTasks(Tasks tasks) {
		return tasksRepository.save(tasks);
	}
	
	public List<Tasks> listAllTasks(){
		return tasksRepository.findAll();
	}
	
	public Tasks searchTasksById(Long id) {
		return tasksRepository.findById(id).orElse(null);
	}
	
	public Tasks updateTask(Long id, Tasks updatedTask) {
		Tasks existingTask = tasksRepository.findById(id).orElse(null);
		if (existingTask != null) {
			existingTask.setName(updatedTask.getName());
			existingTask.setDescription(updatedTask.getDescription());
			existingTask.setDone(updatedTask.getDone());
			existingTask.setPriority(updatedTask.getPriority());
			return tasksRepository.save(existingTask);
		}
		return null;
	}
	public void deleteTask(Long id) {
		tasksRepository.deleteById(id);
	}
}
