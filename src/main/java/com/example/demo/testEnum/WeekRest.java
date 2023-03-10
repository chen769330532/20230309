package com.example.demo.testEnum;

public enum WeekRest implements Week{
	
	SATURDAY("星期六","周六"),SUNDAY("星期天");
	
	
	private String value;
	
	private String value1;
	
	private WeekRest(String value) {
		this.value = value;
	}
	
	private WeekRest(String value,String value1) {
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
