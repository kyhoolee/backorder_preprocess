package com.sendo.coding_question;

import java.util.ArrayList;
import java.util.List;

public class WordMeaning {
	private String word;
	private List<Meaning> meanings;
	
	public WordMeaning() {
		this.meanings = new ArrayList<Meaning>();
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<Meaning> getMeanings() {
		return meanings;
	}
	public void setMeanings(List<Meaning> meanings) {
		this.meanings = meanings;
	}
	
	public void addMeaning(Meaning m) {
		this.meanings.add(m);
	}
	
	public String toResult() {
		String result = "";
		
		for(int i = 0 ; i < meanings.size() ; i ++) {
			result += meanings.get(i).toResult(i+1);
			if(i != meanings.size() - 1)
				result += "\n";
		}
		
		return result;
	}

}
