package com.wipro.springboot.fandemo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.fandemo.controller.FanController;
import com.wipro.springboot.fandemo.entity.Fan;

@RestController
@RequestMapping("/fanrest")
public class FanRestController {
	
	//initial parameter setting of Fan
	public static int speedRegulator=0;
	
	public static String fanDirection="L";
	
	
	

	//leftcord designed as Speed Regulator
	@GetMapping("/leftcord")
	public Fan LeftCord() {
		
		speedRegulator++;
		
		if(speedRegulator<=3) {
			FanController.result= "The Speed has been increased to "+ speedRegulator
				+" "+
				"The Direction is " + (fanDirection.equals("L")? "Anticlockwise":"Clockwise");
		}else {
			speedRegulator=0;
			FanController.result= "The Fan has been turned off";	
			
		}
		return new Fan(speedRegulator,fanDirection,FanController.result);
	}
	
	//rightcord designed as fan Direction
	@GetMapping("/rightcord")
	public Fan RightCord() {
		
			if (fanDirection.equals("L")) {
				fanDirection="R";
			}else {
			fanDirection="L";
		}
		
		if(speedRegulator<=3) {
			FanController.result="The Speed has been increased to "+ speedRegulator
					+"  " +
					 "The Direction is " + (fanDirection.equals("L")? "Anticlockwise":"Clockwise");
			}else {
				speedRegulator=0;
				FanController.result= "The Fan has been turned off";
			}
			
		return new Fan(speedRegulator,fanDirection,FanController.result);
	}
	
	

}
