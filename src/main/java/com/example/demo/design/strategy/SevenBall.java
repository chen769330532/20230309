package com.example.demo.design.strategy;

public class SevenBall implements GameBoy{

	private String game = "七龙珠";
	
	@Override
	public String play() {
		return this.game;
	}
}
