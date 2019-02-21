package com.hxj.cloud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxj.cloud.service.WeatherDataService;
import com.hxj.cloud.service.WeatherReportService;
import com.hxj.cloud.vo.Weather;
import com.hxj.cloud.vo.WeatherResponse;

@Service
public class WeatherReoprtServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataService  weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp=weatherDataService.getDataByCityId(cityId);
		return resp.getData();
	}

}
