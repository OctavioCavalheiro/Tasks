package br.com.octavio.tasks.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class employee {

@GeneratedValue(strategy = GenerationType.IDENTITY)	
private long id;
	
@NotBlank(message = "field cannot be left blank")
private String name;

@NotBlank(message = "field cannot be left blank")
private int age;

@NotBlank(message = "field cannot be left blank")
@Min(value = 11, message = "value must equal 11")
@Max(value = 11, message = "value must equal 11")
private String CPF;


@NotBlank(message = "field cannot be left blank")
private BigDecimal income;


@NotBlank(message = "field cannot be left blank")
private String function;

@NotBlank(message = "field cannot be left blank")
private String department;

@JsonFormat(pattern = "dd/MM/yyyy")
protected LocalDate contractDate = LocalDate.now();

@NotBlank(message = "field cannot be left blank")
private String address;

@NotBlank(message = "field cannot be left blank")
private String email;

@NotBlank(message = "field cannot be left blank")
@Min(value = 9, message = "phone must be greater or equal to 9")
@Max(value = 11, message = "phone must be less or equal to 11")
private String phone;



}
