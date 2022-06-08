package com.chainsys.bestPractices.abstractDemo;

public interface Ispelling {
	void spellCheck(String word); // must be implemented by all languages
	void spellCheckGrammer(String sentence); // must be implemented by all languages
	int wordCount(String sentence);// the logic is same for all languages
}
abstract class Language implements Ispelling {
	@Override
	public int wordCount(String sentence) {
		String [] word =sentence.split(" ");
		return word.length;
	}	
}
class EnglishLanguage extends Language implements Ispelling {

	@Override
	public void spellCheck(String word) {
		System.out.println("English spellchecker");
		
	}

	@Override
	public void spellCheckGrammer(String sentence) {
		System.out.println("English spellchecker");
		
	}

}
class TamilLanguage extends Language implements Ispelling{

	@Override
	public void spellCheck(String word) {
		System.out.println("Tamil spellchecker");
		
	}

	@Override
	public void spellCheckGrammer(String sentence) {
		System.out.println("Tamil spellchecker");
		
	}

}
class FrenchLanguage extends Language implements Ispelling{

	@Override
	public void spellCheck(String word) {
		System.out.println("French spellchecker");
		
	}

	@Override
	public void spellCheckGrammer(String sentence) {
		System.out.println("French spellchecker");
		
	}

}
