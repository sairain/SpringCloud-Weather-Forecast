package com.hxj.cloud.service;

import com.hxj.cloud.vo.Weather;

public interface WeatherReportService {
	/**
	 * 根据城市ID查询天气数据
	 * 
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);

}
