package com.example.demo.easyExcel;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.Builder;
import lombok.Data;

@Data
public class WriteModel extends BaseRowModel{

	@ExcelProperty(value="姓名",index=0)
	private String name;
	
	@ExcelProperty(value="年龄",index=1)
	private String age;
	
	@ExcelProperty(value="密码",index=2)
	private String password;
}
