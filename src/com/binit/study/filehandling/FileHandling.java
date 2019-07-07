package com.binit.study.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {
	
	public static void main(String[] args) {
		
		int numberOfLine = 0;
		int numberOfWord = 0;
		int numberOfChars = 0;
		
		String readLine;
		try {
			
			//Read File
			BufferedReader buffRead = new BufferedReader(new FileReader("C:\\Users\\binit.mohan\\Changes.txt"));
			
			while((readLine = buffRead.readLine()) != null){
				//get total line
				numberOfLine++;	
				
				String [] myWord = readLine.replaceAll("\\s", " ").split(" ");
				
				for(String str : myWord){
					//get total words
					numberOfWord++;
					numberOfChars = numberOfChars + str.length();
				}
				
			}
			
			System.out.println("Line :" + numberOfLine + " Words :" + numberOfWord + " Chars :" + numberOfChars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
