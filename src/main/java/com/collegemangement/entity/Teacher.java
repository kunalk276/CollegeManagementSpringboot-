package com.collegemangement.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="teacher_details1")
public class Teacher 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int tid;
@Column(length = 25, nullable = false)
@NotBlank(message= "Teachar name can not be blank")//validation
private String tname;


@Column(length = 25, nullable = false)
@NotBlank(message= "Teachar tsurname can not be blank")
private String tsurname;


@Column(length = 25, nullable = false, unique = true)
@NotBlank(message= "Teachar temail can not be blank")
@Email(message="Email id is not proper")
private String temail;

@Column(length = 25, nullable = false, unique = true)
@NotBlank(message= "Teachar phone number can not be blank")
private  String tphone;


@Column(length = 25, nullable = false)
@NotBlank(message= "Teachar designation can not be blank")
private String designation;


@OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JsonManagedReference
List<Batches> batchDetails;	 

@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name="deptID", referencedColumnName = "did")
@JsonBackReference
private Department department;






}
