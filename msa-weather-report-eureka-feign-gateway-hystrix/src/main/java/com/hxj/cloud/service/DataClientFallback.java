package com.hxj.cloud.service;

import java.util.ArrayList;
import java.util.List;

import com.hxj.cloud.vo.City;
import com.hxj.cloud.vo.WeatherResponse;

public class DataClientFallback implements DataClient {

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		return null;
	}

	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList=null;
		cityList=new ArrayList<>();
		City city=new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		
		return cityList;
	}

}
