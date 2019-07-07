package com.binit.study.sorting;

public class BubbleSort {
	
	public void sort(int[] arr){
		int n =  arr.length;
		
		for (int i=0; i<n; i++){
			
			for (int j=i+1; j<n; j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
public static void main(String[] args) {
	BubbleSort ob = new BubbleSort();
     int arr[] = {64, 34, 25, 12, 22, 11, 90};
     ob.sort(arr);
     System.out.println("Sorted array B");
     ob.printArray(arr);
}

}
