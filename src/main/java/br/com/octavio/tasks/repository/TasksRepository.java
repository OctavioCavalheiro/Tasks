package br.com.octavio.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.octavio.tasks.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

//adds other dynamic methods
	
}
