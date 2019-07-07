package com.binit.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IteratorClass {

	public static void main(String[] args) {
		List<Integer> items = new ArrayList<>();
		int compare = 8;		
		items.add(1);items.add(6); items.add(45); items.add(2); items.add(11);
		items.add(4); items.add(3); items.add(9);
		for(int i=0; i< items.size(); i++){
			if(items.get(i)< compare){
				items.remove(i);
				i--;
			}
		}	
		Collections.sort(items);
		for(int j = 0; j<items.size(); j++){
			System.out.println(items.get(j));
		}
	}
}

