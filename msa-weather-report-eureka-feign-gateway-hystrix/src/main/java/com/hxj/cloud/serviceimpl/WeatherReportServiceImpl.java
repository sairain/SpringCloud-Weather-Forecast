package com.hxj.cloud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxj.cloud.service.DataClient;
import com.hxj.cloud.service.WeatherReportService;
import com.hxj.cloud.vo.Weather;
import com.hxj.cloud.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {  
	
	@Autowired
	private DataClient dataClient;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp=dataClient.getDataByCityId(cityId);
		Weather data=resp.getData();
		return data;
	}


}
