package com.collegemangement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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
@Table(name= "batch_Details")
public class Batches {

	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int bid;
		
		@Column(length=20, nullable = false)
		//@NotBlank(message = "Batch Name cannot be blank")
		private String bname;
		
		@Column(length=20, nullable = false)
		//@NotBlank(message = "Subject Name cannot be blank")
		private String subject;
		
		@Column(length=20)
		private String startdate;
		
		@Column(length=20)
		private String enddate;
		
		//@Column(nullable = true)
		//@NotNull(message = "Duration cannot be null")
		@Min(value = 1, message = "Duration must be greater than 0")
		private Integer duration;
		
		@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinColumn(name="TeacherId", referencedColumnName = "tid")
		@JsonBackReference
		private Teacher teacher;
}
