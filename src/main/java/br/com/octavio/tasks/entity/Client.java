package br.com.octavio.tasks.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

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
public class Client {

@Id //defines an only key for identifying
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id; 

@NotBlank(message = "field cannot be left blank")
@Size(max = 99, message = "please enter a value smaller than 99")
private String name;

@NotBlank(message = "field cannot be left blank")
@Size(max = 99, message = "please enter a value smaller than 99")
private String email;

@NotBlank(message = "field cannot be left blank")
@CPF
private String cpf;

@NotBlank(message = "field cannot be left blank")
@Size(max = 99, message = "please enter a value smaller than 99")
private String adress;

@JsonFormat(pattern = "dd/MM/yyyy")
protected LocalDate today = LocalDate.now();

public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public Client(long id,
		@NotBlank(message = "field cannot be left blank") @Size(max = 99, message = "please enter a value smaller than 99") String name,
		@NotBlank(message = "field cannot be left blank") @Size(max = 99, message = "please enter a value smaller than 99") String email,
		@NotBlank(message = "field cannot be left blank") @CPF String cpf,
		@NotBlank(message = "field cannot be left blank") @Size(max = 99, message = "please enter a value smaller than 99") String adress,
		LocalDate today) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.cpf = cpf;
	this.adress = adress;
	this.today = today;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getAdress() {
	return adress;
}

public void setAdress(String adress) {
	this.adress = adress;
}

public LocalDate getToday() {
	return today;
}

public void setToday(LocalDate today) {
	this.today = today;
}




}
