package com.wipro.springboot.fandemo.rest;
/**
 * @author binu
 * RestContoller handling Webservice requests
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.fandemo.entity.Fan;
import com.wipro.springboot.fandemo.helper.FanHelperImpl;

@RestController
@RequestMapping("/fanrest")
public class FanRestController {
	@Autowired
	private FanHelperImpl fanHelperService;
	private Fan fan;
	
	

	/**
	 * @author binu
	 * @param value
	 * @return fan
	 */
	@GetMapping("/getregulatorsettings")
	public Fan getRegulatorSettings(@RequestParam String value) {
	fan=fanHelperService.getLatestFanSettings(value);
		return  fan;
	}
	
	
	
	
	

}
