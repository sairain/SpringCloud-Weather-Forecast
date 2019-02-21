package com.hxj.cloud.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.hxj.cloud.service.CityDataService;
import com.hxj.cloud.service.WeatherDataService;
import com.hxj.cloud.vo.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Configurable 
@EnableScheduling
public class WeatherDataSyncJob   {
	
	@Autowired
	private CityDataService cityDataService;
	
	@Autowired
	private WeatherDataService weatherDataService;

	public void work() {
		log.info("Weather Data Sync Job. Start!");
		// 获取城市ID列表
		List<City> cityList = null;
		
		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			log.error("Exception!", e);
		}
		
		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			log.info("Weather Data Sync Job, cityId:" + cityId);
			
			weatherDataService.syncDateByCityId(cityId);
		}
		
		log.info("Weather Data Sync Job. End!");
	}

}
