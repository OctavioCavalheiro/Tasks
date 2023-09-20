package br.com.octavio.tasks.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity //Responsible for persisting data in the base
public class Employee {

	@Id // defines an only key for identifying 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "field cannot be left blank")
	private String name;

	@Min(value = 18)
	private int age;

	@CPF
	private String CPF;

	@DecimalMin(value = "2000.00")
	private BigDecimal income;

	@NotBlank(message = "field cannot be left blank")
	private String job;

	@NotBlank(message = "field cannot be left blank")
	private String department;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate contractDate = LocalDate.now();

	@NotBlank(message = "field cannot be left blank")
	private String address;

	@NotBlank(message = "field cannot be left blank")
	private String email;

	@NotBlank(message = "field cannot be left blank")
	@Min(value = 111111111, message = "phone must be greater or equal to 9")
	@Max(value = 999999999, message = "phone must be less or equal to 11")
	private String phone;


public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



public Employee(long id, @NotBlank(message = "field cannot be left blank") String name, @Min(18) int age,
		@org.hibernate.validator.constraints.br.CPF String cPF, @DecimalMin("2000.00") BigDecimal income,
		@NotBlank(message = "field cannot be left blank") String job,
		@NotBlank(message = "field cannot be left blank") String department, LocalDate contractDate,
		@NotBlank(message = "field cannot be left blank") String address,
		@NotBlank(message = "field cannot be left blank") String email,
		@NotBlank(message = "field cannot be left blank") @Min(value = 111111111, message = "phone must be greater or equal to 9") @Max(value = 999999999, message = "phone must be less or equal to 11") String phone) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	CPF = cPF;
	this.income = income;
	this.job = job;
	this.department = department;
	this.contractDate = contractDate;
	this.address = address;
	this.email = email;
	this.phone = phone;
}



public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public String getCPF() {
	return CPF;
}


public void setCPF(String cPF) {
	CPF = cPF;
}


public BigDecimal getIncome() {
	return income;
}


public void setIncome(BigDecimal income) {
	this.income = income;
}


public String getJob() {
	return job;
}


public void setJob(String job) {
	this.job = job;
}


public String getDepartment() {
	return department;
}


public void setDepartment(String department) {
	this.department = department;
}


public LocalDate getContractDate() {
	return contractDate;
}


public void setContractDate(LocalDate contractDate) {
	this.contractDate = contractDate;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}



}


