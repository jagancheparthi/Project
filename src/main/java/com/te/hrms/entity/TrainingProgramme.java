package com.te.hrms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class TrainingProgramme {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int programmeId;
	private String programmeName;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	
}
