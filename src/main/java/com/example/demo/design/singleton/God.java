package com.example.demo.design.singleton;

//设计模式------单例
public class God {
	
	private God() {};
	
//	private final static God god = new God();
//	
//	//饥汉式
//	public static God getInstance() {
//		return god;
//	}
	
	//懒汉式
	private static God god = new God();
	
	public static God getInstance() {
		if(god == null) {
			god = new God();
		}
		return god;
	}
	
}
