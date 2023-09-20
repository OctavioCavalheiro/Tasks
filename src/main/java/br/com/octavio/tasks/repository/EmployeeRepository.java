package br.com.octavio.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.octavio.tasks.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//adds other dynamic methods
}
