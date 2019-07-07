package com.binit.study;

import java.util.Arrays;

public class ShiftArrayRight {
	
	public static int[] shiftRight(int []arr, int d){
		int []temp = shiftRightOnePos(arr, d);
		int [] temp1 = new int[arr.length];
		boolean flag = false;
		for(int i =0; i<d-1; i++){
			if(flag){
				temp = temp1.clone();
			}
			System.out.println(Arrays.toString(temp));
			temp1[0] = temp[arr.length-1];
			for(int j = 0; j< d; j++){
				temp1[j+1] = temp[j];
				flag = true;
			}
		}
		
		return temp1;
	}
	
	public static int[] shiftRightOnePos(int []arr, int d){
		
		int [] temp = new int[arr.length];
		temp[0] = arr[arr.length-1];
		for(int i = 0; i< d; i++){
			temp[i+1] = arr[i];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int d=4;
		//shiftLeft(arr, d);
		System.out.println(Arrays.toString(shiftRight(arr, d)));
		
	}

}
