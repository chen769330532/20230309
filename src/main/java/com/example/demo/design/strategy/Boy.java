package com.example.demo.design.strategy;

public class Boy {

	//策略模式
	//GameBoy 的接口都是一样的,所以接口是固定的
	//每个gameBoy的游戏主题取决于游戏卡带自己,所以自己实现gameBoy接口的内容
	//GameConsole 是一部游戏机,他有一个接口负责连接所有的卡带
	//Boy 是一个男孩,当你想玩游戏的时候,只要拥有一个游戏机,有自己的卡带,把卡带插入到游戏机即可玩游戏
	public static void main(String[] args) {
		GameConsole gameConsole = new GameConsole(new Pokemon());
		System.out.println(gameConsole.play());
	}
	
	
}
