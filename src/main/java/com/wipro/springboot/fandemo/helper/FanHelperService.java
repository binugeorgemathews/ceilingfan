package com.wipro.springboot.fandemo.helper;

import org.springframework.stereotype.Component;

import com.wipro.springboot.fandemo.entity.Fan;
import com.wipro.springboot.fandemo.rest.FanSettingNotFoundException;
/**
 * 
 * @author binu
 *FanHelperService
 */
@Component
public class FanHelperService implements FanHelperImpl {

	
	//initial parameter setting of Fan
		private static int speedRegulator=0;
		
		private static String fanDirection="L";
		
		private static String message="";
	
	/**@author binu
	 * getting latest FanSettings  based on request provided from pull cords
	 * @ return Fan
	 */
	@Override
	public Fan getLatestFanSettings(String cord) {
		
		try {
			
				switch(cord) {
						case "leftcord"  :speedRegulator++;
										  break;
						case "rightcord" :if (fanDirection.equals("L")) {
							 					fanDirection="R"; 
							 				}
										 else { 
												fanDirection="L"; 
											} 
											break;
						case "getfanpage": System.out.println("back to Fanpage");
											break;
						
						default: throw new Exception("Bad Request!!! Page Not Found") ;
				
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
	/**
	 * For Populating Message Response 
	 * @return message
	 */
	public String populateMessageResponse() {
		
		message=(speedRegulator==0? "The Fan is Off ":"The Fan is On and Speed is "+ speedRegulator)
				+ " The Direction of the Fan is "+(fanDirection.equals("L")? "Anticlockwise":"Clockwise");
		
		return message;
		
	}

}
