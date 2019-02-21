package com.hxj.cloud.service;

import java.util.List;

import com.hxj.cloud.vo.City;

public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
