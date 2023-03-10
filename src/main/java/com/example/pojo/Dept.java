package com.example.pojo;

import lombok.Data;

@Data
public class Dept {

	/**
	 * 部门编号
	 */
	private Integer deptNo;
	
	/**
	 * 部门名称
	 */
	private String dName;
	
	/**
	 * 部门地址
	 */
	private String loc;
}
