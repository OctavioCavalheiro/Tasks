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
@Entity //responsable for persisting data in the base
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
@Min(value = 11, message = "please enter a value equal to 11")
@Max(value = 11, message = "please enter a value equal to 11")
private String cpf;

@NotBlank(message = "field cannot be left blank")
@Size(max = 99, message = "please enter a value smaller than 99")
private String endereco;

@NotBlank(message = "field cannot be left blank")
@Size(max = 99, message = "please enter a value smaller than 99")
private int houseNumber;

@JsonFormat(pattern = "dd/MM/yyyy")
protected LocalDate today = LocalDate.now();











	
}
