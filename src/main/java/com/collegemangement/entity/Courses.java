package com.collegemangement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Courses {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cid;
		
		@Column(length=20, nullable = true)
		@NotBlank(message = "Course Name cannot be blank")
		private String courseName;
		
		@Column(length=8, nullable = true)
		@NotBlank(message = "Duration cannot be blank")
		private String duration;
		
		@Column(length=10, nullable = true)
		@NotNull(message = "Fees cannot be blank")
		private double courseFees;
		
		
		@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JsonBackReference
		private Student student;
}
