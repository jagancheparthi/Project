package com.te.hrms.entity;

import java.time.LocalDate;

import com.te.hrms.enums.LeaveStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
public class LeaveRequest {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int requestId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String leaveType;
	@Enumerated
	private LeaveStatus leaveStatus;
	private String reason;
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
}
