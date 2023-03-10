package com.example.demo.design.template;

//模板
public abstract class Suckle {

	//定义系女的
	private final static boolean FEMALE = true;
	
	public void feed() {
		if(!FEMALE) {
			System.out.println("男的不能喂孩子");
		}
		System.out.println("在喂孩子");
	}
	
	public abstract void howToFeed();
	
}
