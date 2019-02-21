package com.hxj.cloud.service;

import com.hxj.cloud.vo.WeatherResponse;

public interface WeatherDataService {

	WeatherResponse getDataByCityId(String cityId);
	
	WeatherResponse getDataByCityName(String cityName);
	
}
