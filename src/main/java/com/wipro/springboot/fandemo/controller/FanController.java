package com.wipro.springboot.fandemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.springboot.fandemo.rest.FanRestController;

@Controller
@RequestMapping("/fanbasic")
public class FanController {
	
	public static String result="The Fan is on off mode";
	
	@RequestMapping("/getfanpage")
	public String getFanPage(Model theModel) {
		
			theModel.addAttribute("message", result);
		
		return "fanpage";
	}
	
	@RequestMapping("/leftpullcord")
	public String leftPullCord(Model theModel) {
		FanRestController.speedRegulator++;
		 result=null;
		if(FanRestController.speedRegulator<=3) {
			result= "The Speed has been increased to "+ FanRestController.speedRegulator
					+'\n'+
					"The Direction is " + (FanRestController.fanDirection.equals("L")? "Anticlockwise":"Clockwise");
			}else {
				FanRestController.speedRegulator=0;
				result= "The Fan has been turned off";
			}
		theModel.addAttribute("message", result);
		return "fanpage";
	}
	
	@RequestMapping("/rightpullcord")
	public String rightPullCord(Model theModel) {
		 result=null;
		if (FanRestController.fanDirection.equals("L")) {
			FanRestController.fanDirection="R";
		}else {
			FanRestController.fanDirection="L";
		}
		
		if(FanRestController.speedRegulator<=3) {
			result= "The Speed has been increased to "+ FanRestController.speedRegulator
					+'\n'
					+ "The Direction is " + (FanRestController.fanDirection.equals("L")? "Anticlockwise":"Clockwise");
			}else {
				FanRestController.speedRegulator=0;
				result= "The Fan has been turned off";
			}
		theModel.addAttribute("message", result);
		return "fanpage";
	}

}
