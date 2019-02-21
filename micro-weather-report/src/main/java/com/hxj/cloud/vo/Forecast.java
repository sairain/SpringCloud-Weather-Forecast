package com.hxj.cloud.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Forecast implements Serializable {

	private static final long serialVersionUID = 1L;
	private String date;
	private String high;
	private String fengli;
	private String low;
	private String fengxiang;
	private String type;

}
