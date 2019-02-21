package com.hxj.cloud.serviceimpl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxj.cloud.service.WeatherDataService;
import com.hxj.cloud.vo.WeatherResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	private static final String WEATHER_URI="http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static final long TIME_OUT=1800L;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		String uri=WEATHER_URI+"citykey="+cityId;
		return this.doGetWeather(uri);	
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri=WEATHER_URI+"city="+cityName;
		return this.doGetWeather(uri);
	}

	private WeatherResponse doGetWeather(String uri){
		
		String key=uri;
		String strBody=null;
		ObjectMapper mapper=new ObjectMapper();
		WeatherResponse resp=null;	
		ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
		
		//先查缓存,缓存中存在则在缓存中取出数据
		if(stringRedisTemplate.hasKey(key)){
			log.info("Redis has data");
			strBody=ops.get(key);
		}
		else{
			//缓存没有,则调用服务接口获取
			log.info("Redis has not data");
			ResponseEntity<String> respString=restTemplate.getForEntity(uri, String.class);		
			
			if(respString.getStatusCodeValue()==200){
				strBody=respString.getBody();
			}
		}
		
		//数据写入缓存
		ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		
		try{
			resp=mapper.readValue(strBody, WeatherResponse.class);
		}
		catch(IOException e){
			log.error("Error",e);
		}
		return resp;
	}
	
}
