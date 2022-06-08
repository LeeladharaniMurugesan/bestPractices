package com.chainsys.bestPractices.abstractDemo;

public class ScoreBoard {
	public int TargetScore=200;
	private ScoreBoard() {
		System.out.println("Object is created for ScoreBoard");
	}
	public static ScoreBoard createObject() {
		return new ScoreBoard();
	}
}
