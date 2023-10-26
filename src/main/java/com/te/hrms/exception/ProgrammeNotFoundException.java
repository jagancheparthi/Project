package com.te.hrms.exception;

public class ProgrammeNotFoundException extends Exception{
	private String msg;
	public ProgrammeNotFoundException(String msg) {
		super(msg);
	}
}
