package com.sendo.coding_question;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {
	
	public static void writeFile(String file, String data) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String file, List<String> data) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for(String d : data)
				bw.write(d);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
