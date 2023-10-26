package com.te.hrms.enums;

public enum LeaveStatus {
	PENDING("PENDING"),APPROVED("APPROVED"),REJECTED("REJECTED");
	private String leaveStatus;
	private LeaveStatus(String leaveStatus) {
		this. leaveStatus= leaveStatus;
	}
	public String getLeaveStatus() {
		return this.leaveStatus;
	}
}
