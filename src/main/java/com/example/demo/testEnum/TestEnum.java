package com.example.demo.testEnum;

import java.util.Arrays;

import org.springframework.util.StringUtils;

public class TestEnum {
	
	public static void main(String[] args) {
//		test1();
//		test2();
		Week w = WeekRest.SATURDAY;
		System.out.println(Arrays.toString(w.everyDay()));
	}

	private static void test2() {
		WeekWork monday = WeekWork.MONDAY;
		switch(monday) {
		case MONDAY:
			System.out.println(1);
			break;
		case TUESDAY:
			System.out.println(2);
			break;
		case WEDNESDAY:
			System.out.println(3);
			break;
		case THURSDAY:
			System.out.println(4);
			break;
		}
	}

	private static void test1() {
		WeekWork monday = WeekWork.MONDAY;
		System.out.println(monday.getValue());
		System.out.println(monday.getValue1());
		
		System.out.println("\n---------------------\n");
		
		for(WeekWork week : WeekWork.values()) {
			System.out.println("遍历输出week枚举Value值:"+week+",排序值:"+week.ordinal());//week.ordinal()  int 类型
			System.out.println("遍历输出week枚举Value值:"+week.getValue());
			System.out.println(StringUtils.isEmpty(week.getValue1())?null:"遍历输出week枚举Value值:"+week.getValue1());
			if("MONDAY".equals(week.name())) {
				System.out.println("今天是星期一");
			}
			if(monday.equals(week)) {
				System.out.println("比较星期一的hashCode相等");//枚举默认重写hashCode
			}
		}
	}
	
}
