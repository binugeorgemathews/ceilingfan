package com.wipro.springboot.fandemo.entity;

public class Fan {

	
	public int speedSetting;
	
	public String fanDirection;
	
	public String message;

	public Fan(int speedSetting, String fanDirection, String message) {
		super();
		this.speedSetting = speedSetting;
		this.fanDirection = fanDirection;
		this.message = message;
	}
	
	
}
