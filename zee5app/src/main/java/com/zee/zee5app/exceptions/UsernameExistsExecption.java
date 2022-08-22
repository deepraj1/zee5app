package com.zee.zee5app.exceptions;

public class UsernameExistsExecption extends Exception {
	public UsernameExistsExecption(String messeage) {
		// TODO Auto-generated constructor stub
		super(messeage);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
