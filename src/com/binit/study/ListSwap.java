package com.binit.study;

import java.util.ArrayList;
import java.util.List;

public class ListSwap {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();

		lst.add("abc");
		lst.add("def");
		lst.add("ghi");
		lst.add("jkl");
		lst.add("mno");
		for(String str: lst){
			System.out.println(str+ " ");
		}
		int size =  lst.size();
		for(int i=0; i<size; i++){
			String temp = lst.get(i);
			lst.add(i, lst.get(size-i));
			lst.add(size-i, temp);
		}
for(String str: lst){
	System.out.println(str+ " ");
}


	}
}
