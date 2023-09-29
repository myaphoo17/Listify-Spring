package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repo.TaskRepository;
import entities.Task;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private static TaskRepository taskrepo;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        TaskService.taskrepo = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskrepo.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskrepo.findById(id);
    }

    public static Task createTask(Task task) {
        
        try {
			return taskrepo.save(task);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        
        Optional<Task> existingTask = taskrepo.findById(id);

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            
            task.setText(updatedTask.getText());
            task.setCompleted(updatedTask.isCompleted());

          
            return taskrepo.save(task);
        } else {
         
            return null;
        }
    }

    public void deleteTask(Long id) {
        taskrepo.deleteById(id);
    }
}

