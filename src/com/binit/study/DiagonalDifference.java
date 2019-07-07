package com.binit.study;

import java.util.List;

public class DiagonalDifference {
	
	 /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    int leftTotal = leftDigonalDiff(arr);
    int rightTotal = rightDigonalDiff(arr);
    //System.out.println("leftTotoal " + leftTotal);

    return Math.abs(leftTotal - rightTotal);
    }

     public static int leftDigonalDiff(List<List<Integer>> arr) {
         int lefttotal = 0;
         int j = 0;
         for(int i = 0; i < arr.size(); i++){
             List<Integer> temp = arr.get(i);
            lefttotal = lefttotal + temp.get(j);
            j++;
         }
         return lefttotal;
     }

     public static int rightDigonalDiff(List<List<Integer>> arr) {
         int rightTotal = 0;
         int j = arr.;
         for(int i = 0; i<arr.size(); i++){
             List<Integer> temp = arr.get(i);
            rightTotal = rightTotal + temp.get(j);
            j--;
         }
         return rightTotal;
     }

     public static void main(String[] args) {
		
	}

}
