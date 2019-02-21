package com.hxj.could.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxj.could.service.WeatherDataService;
import com.hxj.could.vo.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService  weatherDataService;
	
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
		return weatherDataService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
		return weatherDataService.getDataByCityName(cityName);
	}
	
}
