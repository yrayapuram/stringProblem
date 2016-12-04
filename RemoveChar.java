package com.apple;

import java.util.regex.PatternSyntaxException;

public class RemoveChar {
	
	private String orgWord;
	
	private char orgChar;
	
	//getter and setter methods for taking the inputs
	public String getOrgWord() { return orgWord; }
	
	public void setOrgWord(String orgWord) { this.orgWord = orgWord; }
	
	public char getOrgChar() { return orgChar; }
	
	public void setOrgChar(char orgChar) { this.orgChar = orgChar; }
	
	//2. Find a method in the String class that can solve this in one line
	public String removeCharV1(String orgWord, char orgChar) throws PatternSyntaxException {
		if(orgWord == null) {return null;}
		return orgWord.replaceAll(Character.toString(orgChar),"");
	}
	
	//1. Iterate through the String, one character at a time 
	public String removeCharV2(String orgWord, char orgChar) {
		if(orgWord == null) { return null;}
		StringBuilder newWord = new StringBuilder();
		for(char letter: orgWord.toCharArray()){
			if(letter != orgChar) newWord.append(letter);
		}
		return newWord.toString();
	}
  
}
