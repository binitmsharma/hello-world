package com.binit.study;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
	
	public void sort(List<Integer> lst){
		
		for(int i = 1; i < lst.size(); i++){
			while(i <= 0){
				
			}
			if(lst.get(i) < lst.get(i-1)){
				
			}
		}
	}
	
	public static void sort(int [] arrLst){
		for(int i = 1; i < arrLst.length; ++i){
			
			int key = arrLst[i];
			while(i > 0 && arrLst[i] < key){
				if (arrLst[i]< arrLst[i-1]){
					int temp = arrLst[i-1];
					arrLst[i-1] = arrLst[i];
					arrLst[i] = temp;
					i--;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(5);
		lst.add(3); lst.add(6); lst.add(1); lst.add(2); lst.add(8); lst.add(2);

		int [] arrLst = {4, 3, 6, 8, 2, 1};
		
		for(int i = 0; i< arrLst.length; i++){
			System.out.println(arrLst[i]);
		}
		System.out.println("Before sorting :" + arrLst.toString());
		InsertionSort.sort(arrLst);
		System.out.println("After sorting :" + arrLst.toString());
		for(int i = 0; i< arrLst.length; i++){
			System.out.println(arrLst[i]);
		}
		
	}

}
