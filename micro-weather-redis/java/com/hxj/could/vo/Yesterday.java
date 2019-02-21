package com.hxj.could.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Yesterday implements  Serializable {

	private static final long serialVersionUID = -210779120490037331L;

	private String date;
	
	private String high;
	
	private String fx;
	
	private String low;
	
	private String fl;
	
	private String type;

}
