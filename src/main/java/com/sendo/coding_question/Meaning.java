package com.sendo.coding_question;

import java.util.ArrayList;
import java.util.List;

public class Meaning {
	private String meaning;
	private List<String> examples;
	
	public Meaning() {
		this.examples = new ArrayList<String>();
	}
	
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public List<String> getExamples() {
		return examples;
	}
	public void setExamples(List<String> examples) {
		this.examples = examples;
	}
	
	public void addExample(String exp) {
		this.examples.add(exp);
	}
	


	public String toResult(int i) {
		String result = "";
		result += "meaning " + i + ": " + meaning;
		for(int j = 0 ; j < examples.size() ; j ++) {
			result += "\nexample " + (j+1) + " of meaning " + i + ": " + examples.get(j);
		}
		return result;
	}
	


}
