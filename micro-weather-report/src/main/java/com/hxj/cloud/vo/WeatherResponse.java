package com.hxj.cloud.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class WeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Weather data;
	private Integer status;
	private String desc;
	
}
