package com.example.demo.design.strategy;

public class Pokemon implements GameBoy{

	private String game = "宝可梦";
	
	@Override
	public String play() {
		return this.game;
	}



}
