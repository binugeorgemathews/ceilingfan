package com.wipro.springboot.fandemo.rest;

public class FanSettingNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public FanSettingNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FanSettingNotFoundException(String message) {
		super(message);
		
	}

	public FanSettingNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
