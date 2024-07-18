package com.collegemangement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="dept1")
public class Department {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private int did;
	
	@Column(length=20, nullable = true)
	@NotBlank(message = "Department Name cannot be blank")
	private String deptName;
	
	@Column(length=20)
	private String deptHOD;
	
	@Column(length=40, nullable = true)
	@NotNull(message = "kindly mention no of employess")
	private int noOfEmpl;

	@OneToMany(mappedBy = "department",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Teacher> teacherList;	 
	
	}

