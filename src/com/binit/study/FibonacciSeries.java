package com.binit.study;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
	
	public void fibSeries(){
		int f0 = 0;
		int f1 = 1;
		int total = 0;
		int [] fivser1 = {};
		//System.out.println(f0 + " "+ f1);
		for (int i = 2; i<10; i++ ){
			fivser1[i] = fivser1[i-1] + fivser1[i-2];
		}
	}
public static void main(String[] args) {
	int f0 = 0;
	int f1 = 1;
	int total = 0;
	List<Integer>  fivser1= new ArrayList<Integer>();
	fivser1.add(0);
	fivser1.add(1);
	//System.out.println(f0 + " "+ f1);
	for (int i = 2; i<10; i++ ){
		fivser1.add(fivser1.get(i-1) + fivser1.get(i-2));
	}
	System.out.println(fivser1.toString());
}
}
