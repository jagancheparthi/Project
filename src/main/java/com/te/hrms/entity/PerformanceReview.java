package com.te.hrms.entity;

import java.time.LocalDate;

import com.te.hrms.enums.Rating;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class PerformanceReview {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int reviewId;
	private LocalDate reviewDate;
	private String reviewName;
	private String reviersComments;
	private Rating performanceRating;
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
	
}
