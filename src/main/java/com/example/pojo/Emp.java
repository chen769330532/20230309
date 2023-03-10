package com.example.pojo;

import lombok.Data;

@Data
public class Emp {
	
	/**
	 * 员工编号
	 */
	private Integer empNo;
	
	/**
	 * 员工姓名
	 */
	private String eName;
	
	/**
	 * 员工岗位
	 */
	private String job;
	
	/**
	 * 员工领导编号
	 */
	private Integer mgr;
	
	/**
	 * 入职日期
	 */
	private String hireDate;
	
	/**
	 * 工资
	 */
	private Double sal;
	
	/**
	 * 奖金
	 */
	private Double comm;
	
	/**
	 * 部门编号
	 */
	private Integer deptNo;
	
}
