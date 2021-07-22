package com.wipro.springboot.fandemo.helper;

import com.wipro.springboot.fandemo.entity.Fan;

public interface FanHelperImpl {
	
	public Fan getLatestFanSettings(String cord);

}
