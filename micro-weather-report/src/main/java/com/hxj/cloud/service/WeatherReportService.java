package com.hxj.cloud.service;

import com.hxj.cloud.vo.Weather;

public interface WeatherReportService {

	Weather getDataByCityId(String cityId);
	
}
