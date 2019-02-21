package com.hxj.cloud.service;

public interface WeatherDataCollectionService {	
	/**
	 * 根据城市ID来同步天气
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);
	
}
