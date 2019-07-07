/*The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in . 
The second line contains  space-separated integers describing the colors  of the socks in the pile.

Constraints

 where 
Output Format

Return the total number of matching pairs of socks that John can sell.

Sample Input

9
10 20 20 10 10 30 50 10 20
Sample Output

3*/



package com.binit.study;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	
	  // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] sockArray) {
    	 int matchCount = 0;
    	    int currentColor = 0;
    	    int length = sockArray.length;
    	 
    	    List<Integer> sockColorsArray = new ArrayList<Integer>();
    	    for(int i = 0; i < length; i++){
    	      currentColor = sockArray[i];
    	      if(sockColorsArray.contains(currentColor)){
    	         matchCount++;
    	         sockColorsArray.remove(new Integer(currentColor));
    	      }else{
    	         sockColorsArray.add(new Integer(currentColor)); 
    	      }
    	    }
    	    return matchCount;
    }
    
    public static void main(String[] args) {
		int []ar =  {10, 20, 20, 10, 10, 30, 50, 10, 20};
    	sockMerchant(9, ar);
	}
}
