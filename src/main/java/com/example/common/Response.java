package com.example.common;

import lombok.Data;

@Data
public class Response<T> {
	
	private String msg;
	
	private String status;
	
	private T data;

	private int total;
}
