package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Repo.TaskRepository;
import entities.Task;
import service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

	@Autowired
	private TaskRepository taskrepo;

	@GetMapping
	private List<Task> getAllTAsks() {
		return taskrepo.findAll();

	}


	@PostMapping("/api/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
	   
	    Task createdTask = null;
		try {
			createdTask = TaskService.createTask(task);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
	}


	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
		Task task = taskrepo.findById(id).orElse(null);
		if (task != null) {
			task.setText(updatedTask.getText());
			task.setCompleted(updatedTask.isCompleted());
			return taskrepo.save(task);

		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskrepo.deleteById(id);
	}
	   @RequestMapping(method = RequestMethod.OPTIONS)
	    public ResponseEntity<?> handleOptions() {
	        return ResponseEntity.ok().build();
}
}