package com.wipro.springboot.fandemo.helper;

import org.springframework.stereotype.Component;

import com.wipro.springboot.fandemo.entity.Fan;
import com.wipro.springboot.fandemo.rest.FanSettingNotFoundException;

@Component
public class FanHelperService implements FanHelperImpl {

	
	//initial parameter setting of Fan
		public static int speedRegulator=0;
		
		public static String fanDirection="L";
		
		public static String message="";
		
	@Override
	public Fan getLatestFanSettings(String cord) {
		
		try {
				if(cord.equals("leftcord")) {
					speedRegulator++;
					
				}else if (cord.equals("rightcord")){
					if (fanDirection.equals("L")) {
						fanDirection="R";
					}else {
						fanDirection="L";
					}
				}else if (cord.equals("getfanpage")) {
					System.out.println("back to Fanpage");
				}else {
					throw new  Exception("Bad Request!!! Page Not Found") ;
				}
				
				if(speedRegulator>3) {
					speedRegulator=0;	
				}
				populateMessageResponse(); 
				
		}catch (Exception ex){
			throw new FanSettingNotFoundException(ex.getMessage());
		}
		
		return new Fan(speedRegulator,fanDirection,message);
	}
	
	public String populateMessageResponse() {
		
		message=(speedRegulator==0? "The Fan is Off ":"The Fan is On and Speed is "+ speedRegulator)
				+ " The Direction of the Fan is "+(fanDirection.equals("L")? "Anticlockwise":"Clockwise");
		
		return message;
		
	}

}
