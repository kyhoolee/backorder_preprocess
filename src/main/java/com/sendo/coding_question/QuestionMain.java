package com.sendo.coding_question;

import java.util.Scanner;

public class QuestionMain {
	private static Scanner scanner;




	public static void example() {
		OxfordScraper s = new OxfordScraper();
		
		s.extract("not go far", "output.txt");
		s.extract("by far", "output.txt");
		s.extract("not for love or/nor money", "output.txt");
	}
	
	public static void quesionLoop() {
		scanner = new Scanner(System.in);
		OxfordScraper s = new OxfordScraper();
		while(true) {
	        System.out.println("Please enter the idiom:");
	        String idiom = scanner.nextLine();
	        s.extract(idiom, "output.txt");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		quesionLoop();
	}
}
