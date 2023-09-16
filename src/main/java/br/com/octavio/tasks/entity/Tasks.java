package br.com.octavio.tasks.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //Responsible for persisting data in the base
public class Tasks {

@Id //defines an only key for identifying
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "the field name cannot be left blank")
@Size(max = 100, message = "please enter a value smaller than 100")
private String name;

@NotBlank(message = "the field description cannot be left blank")
@Size(max = 100, message = "please enter a value smaller than 100")
private String description;

private Boolean done;   

@Min(value = 1, message = "priority must be greater or equal to 1")
@Max(value = 10, message = "priority must be less than 10")
private int priority;

@JsonFormat(pattern = "dd/MM/yyyy")
protected LocalDate dateCreation = LocalDate.now();

public Tasks() {
	super();
	// TODO Auto-generated constructor stub
}

public Tasks(Long id,
		@NotBlank(message = "the field name cannot be left blank") @Size(max = 100, message = "please enter a value smaller than 100") String name,
		@NotBlank(message = "the field description cannot be left blank") @Size(max = 100, message = "please enter a value smaller than 100") String description,
		Boolean done,
		@Min(value = 1, message = "priority must be greater or equal to 1") @Max(value = 10, message = "priority must be less than 10") int priority,
		LocalDate dateCreation) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.done = done;
	this.priority = priority;
	this.dateCreation = dateCreation;
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Boolean getDone() {
	return done;
}

public void setDone(Boolean done) {
	this.done = done;
}

public int getPriority() {
	return priority;
}

public void setPriority(int priority) {
	this.priority = priority;
}

public LocalDate getDateCreation() {
	return dateCreation;
}

public void setDateCreation(LocalDate dateCreation) {
	this.dateCreation = dateCreation;
} 




	
}

