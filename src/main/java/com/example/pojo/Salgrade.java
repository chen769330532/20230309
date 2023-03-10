package com.example.pojo;

import lombok.Data;

@Data
public class Salgrade {

	/**
	 * 等级
	 */
	private Integer grade;
	
	/**
	 * 最低工资
	 */
	private Double losal;
	
	/**
	 * 最高工资
	 */
	private Double hisal;
}
