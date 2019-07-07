package com.binit.study.sorting;

public class SelectionSort1 {
	
	public void sort(int[] arr){
		int n = arr.length;
		
		for(int i=0; i<n-1; i++){
			int min_idx = i;
			for(int j=1; j<n-1; j++){
				if(arr[min_idx] > arr[j] )
					min_idx = j;
			}
			int temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;
		}
	}
	
	public void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		 SelectionSort ob = new SelectionSort();
	        int arr[] = {64,25,12,22,11};
	        ob.sort(arr);
	        System.out.println("Sorted array B");
	        ob.printArray(arr);
	}

}
