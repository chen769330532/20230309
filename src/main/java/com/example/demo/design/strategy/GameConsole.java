package com.example.demo.design.strategy;

public class GameConsole {
	
	private String play;
	
	public GameConsole(GameBoy gameBoy) {
		play = gameBoy.play();
	}
	
	public String play() {
		return play;
	}
}
