package com.te.hrms.exception;

public class SkillNotFoundException extends Exception{
	private String msg;
	public SkillNotFoundException(String msg) {
		super(msg);
	}
}
