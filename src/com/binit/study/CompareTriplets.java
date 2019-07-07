package com.binit.study;

import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {
	
	 // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> temp = new ArrayList();
        int totalA = 0;
        int totalB = 0;
        for(int i = 0; i< a. size(); i++){

            if(a.get(i)>b.get(i) ){
                totalA = totalA+1;
            } else if (a.get(i)<b.get(i)){
            	totalB = totalB + 1;
            }
        }
        temp.add(totalA);
        temp.add(totalB);
        return temp;

    }
    
    public static void main(String[] args) {
		
	}

}
