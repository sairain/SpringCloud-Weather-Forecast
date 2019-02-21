package com.hxj.cloud.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.hxj.cloud.service.CityClient;
import com.hxj.cloud.service.WeatherDataCollectionService;
import com.hxj.cloud.vo.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Configurable 
@EnableScheduling
public class WeatherDataSyncJob   {
	
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;

	@Autowired
	private CityClient cityClient;
	
	public void work() {
		log.info("Weather Data Sync Job. Start!");
		// 获取城市ID列表
		List<City> cityList = null;
		
		try {
						cityList = cityClient.listCity();
		} catch (Exception e) {
			log.error("Exception!", e);
		}
		
		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			log.info("Weather Data Sync Job, cityId:" + cityId);
			
			weatherDataCollectionService.syncDateByCityId(cityId);
		}
		
		log.info("Weather Data Sync Job. End!");
	}

}
