package Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

		
	}
