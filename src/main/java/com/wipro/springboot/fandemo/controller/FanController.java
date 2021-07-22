package com.wipro.springboot.fandemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.springboot.fandemo.entity.Fan;
import com.wipro.springboot.fandemo.helper.FanHelperImpl;

@Controller
@RequestMapping("/fanbasic")
public class FanController {
	
	
	@Autowired
	private FanHelperImpl fanHelperService;
	private Fan fan; 
	
	
	@RequestMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	@RequestMapping("/getfanpage")
	public String getFanPage(Model theModel) {
		fan=fanHelperService.getLatestFanSettings("getfanpage");
			theModel.addAttribute("message", fan.message);
		return "fanpage";
	}

	@RequestMapping("/leftpullcord")
	public String leftPullCord(Model theModel) {
		fan=fanHelperService.getLatestFanSettings("leftcord");
		theModel.addAttribute("message", fan.message);
		return "fanpage";
	}
	
	@RequestMapping("/rightpullcord")
	public String rightPullCord(Model theModel) {
		fan=fanHelperService.getLatestFanSettings("rightcord");
		theModel.addAttribute("message", fan.message);
		return "fanpage";
	}

}
