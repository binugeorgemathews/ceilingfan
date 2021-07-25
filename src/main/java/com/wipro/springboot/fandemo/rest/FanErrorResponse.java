package com.wipro.springboot.fandemo.rest;
/**
 * 
 * @author binu
 * ErrorResponse class with properties showing 
 *
 */
public class FanErrorResponse {

	
	private int status;
	private String message;
	private long timeStamp;
	/**
	 * Default Constructor
	 */
	public FanErrorResponse() {
		
	}
	/**
	 * Constructor
	 * @param status
	 * @param message
	 * @param timeStamp
	 */
	public FanErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	/**
	 * Getter of status
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * Setter of status
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * Getter of message
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Setter of message
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Getter of timeStamp
	 * @return timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * Setter of timeStamp
	 * @param timeStamp
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * toString Method
	 */
	@Override
	public String toString() {
		return "FanErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
}
