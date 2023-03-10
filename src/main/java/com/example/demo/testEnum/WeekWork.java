package com.example.demo.testEnum;

public enum WeekWork implements Week{
	MONDAY("星期一","周一"),TUESDAY("星期二"),WEDNESDAY("星期三","周三"),THURSDAY("星期四"),FRIDAY("星期五","周五");
	
	private String value;
	
	private WeekWork(String value) {
		this.value = value;
	}

	private String value1;
	

	private WeekWork(String value,String value1) {
		this.value=value;
		this.value1=value1;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	@Override
	public String[] everyDay() {
		WeekRest[] values = WeekRest.values();
		String[] a= new String [ values.length];
		for(int i = 0;i<a.length;i++) {
			a[i]=values[i].name();
		}
		return a;
	}


	
	
	
}
