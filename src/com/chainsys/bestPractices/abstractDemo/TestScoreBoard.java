package com.chainsys.bestPractices.abstractDemo;

public class TestScoreBoard {
	public static void main (String args[]) {
		ScoreBoard s1 =ScoreBoard.createObject();
		System.out.println(s1.TargetScore);
		s1.TargetScore=190;
		System.out.println(s1.TargetScore);
		
	}

}
