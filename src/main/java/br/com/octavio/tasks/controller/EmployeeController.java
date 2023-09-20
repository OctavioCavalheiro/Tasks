package br.com.octavio.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.octavio.tasks.entity.Employee;
import br.com.octavio.tasks.services.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;
	
	@PostMapping
	public ResponseEntity<Employee> createTasks(@RequestBody Employee employee) {
		Employee newEmployee = employeeServices.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> listAllEmployee() {
		List<Employee> allEmployee = employeeServices.listAllEmployee();
		return ResponseEntity.ok(allEmployee);}
		
	@GetMapping("/{id}")
	public ResponseEntity<?> searchEmployeeById(@PathVariable Long id) {
		Employee employee = employeeServices.searchEmployeeById(id);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee not found");
		}
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee UpdatedEmployee) {
		Employee employee = employeeServices.updateEmployee(id, UpdatedEmployee);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found");
		}
		
	}	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
	employeeServices.deleteEmployee(id);
	return ResponseEntity.noContent().build();
	}
}














