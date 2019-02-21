package com.hxj.could.service;

import com.hxj.could.vo.WeatherResponse;

public interface WeatherDataService {

	WeatherResponse getDataByCityId(String cityId);
	
	WeatherResponse getDataByCityName(String cityName);
	
}
