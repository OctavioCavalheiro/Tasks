package br.com.octavio.tasks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.octavio.tasks.entity.Client;
import br.com.octavio.tasks.entity.Employee;
import br.com.octavio.tasks.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee Employee) {
		return employeeRepository.save(Employee);
	}
	
	public List<Employee> listAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee searchEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		if (existingEmployee != null) {
			existingEmployee.setName(updatedEmployee.getName());
			existingEmployee.setAge(updatedEmployee.getAge());
			existingEmployee.setCPF(updatedEmployee.getCPF());
			existingEmployee.setIncome(updatedEmployee.getIncome());
			existingEmployee.setJob(updatedEmployee.getJob());
			existingEmployee.setDepartment(updatedEmployee.getDepartment());
			existingEmployee.setContractDate(updatedEmployee.getContractDate());
			existingEmployee.setAddress(updatedEmployee.getAddress());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			existingEmployee.setPhone(updatedEmployee.getPhone());	
			return employeeRepository.save(existingEmployee);
			} 
		return null;
		}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
		
	

