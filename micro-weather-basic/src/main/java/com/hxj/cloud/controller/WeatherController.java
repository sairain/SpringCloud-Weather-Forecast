package com.hxj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hxj.cloud.service.WeatherDataService;
import com.hxj.cloud.vo.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService  weatherDataService;

	/**
	 * @Author 幻小觉
	 * @Date 2018/12/30 11:08
	 * @Param [cityId]
	 * @Return com.hxj.cloud.vo.WeatherResponse
	 */
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
		return weatherDataService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
		return weatherDataService.getDataByCityName(cityName);
	}

}
