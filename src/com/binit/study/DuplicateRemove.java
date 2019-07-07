package com.binit.study;

import java.util.Arrays;

public class DuplicateRemove {

	public static void removeDuplicate(int [] arr, int lenght){
		 int [] temp = new int[5];
		 int j = 0;
		 int i=0;
		 for(; i<lenght-1; i++){
			 if(arr[i] != arr[i+1]){
				 temp[j] = arr[i];
				 j++;
			 }
		 }
		 temp[j] = arr[i-1];
		 
		 System.out.println("Array :" + Arrays.toString(temp));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,2,2,4,4,5,5,7,7};
		int lenght = arr.length;
		removeDuplicate(arr, lenght);
	

	}

}
