package com.hxj.cloud.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;


public class Weather implements Serializable{

	private static final long serialVersionUID = 5171422363555681848L;

	@Value("${name}")
	private String city;
	
	private String aqi;
	
	private String ganmao;
	
	private String wendu;
	
	private Yesterday yesterday;
	
	private List<Forecast> forecast;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
