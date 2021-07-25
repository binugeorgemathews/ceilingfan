package com.wipro.springboot.fandemo.helper;

import com.wipro.springboot.fandemo.entity.Fan;
/**
 * 
 * @author binu
 * Interface class FanHelperImpl
 */
public interface FanHelperImpl {
	
	/**
	 * Interface method invoking latest Fan Settings
	 * @param cord
	 * @return Fan
	 */
	public Fan getLatestFanSettings(String cord);

}
