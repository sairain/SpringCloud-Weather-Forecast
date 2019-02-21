package com.hxj.cloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hxj.cloud.vo.City;
import com.hxj.cloud.vo.WeatherResponse;

@FeignClient(name="msa-weather-eureka-client-zuul",fallback=DataClientFallback.class)
public interface DataClient {

	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
	
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	
}
