package com.wipro.springboot.fandemo.entity;
/**
 * 
 * @author binu
 * Fan Entity for Webservice Response having properties defined for Setting
 *
 */
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
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Fan [speedSetting=" + speedSetting + ", fanDirection=" + fanDirection + ", message=" + message + "]";
	}
	
	
}
