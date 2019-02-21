package com.hxj.could.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Weather implements Serializable{

	private static final long serialVersionUID = 5171422363555681848L;

	private String city;
	
	private String aqi;
	
	private String ganmao;
	
	private String wendu;
	
	private Yesterday yesterday;
	
	private List<Forecast> forecast;
	
}
