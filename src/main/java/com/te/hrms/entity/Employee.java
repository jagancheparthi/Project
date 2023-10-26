package com.te.hrms.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Employee {
	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private LocalDate dateOfJoining;
	private String department;
	private String designation;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Skill> skills;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TrainingProgramme> trainingProgramme;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Role> roles;
}
