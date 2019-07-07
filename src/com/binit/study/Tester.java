package com.binit.study;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tester implements Runnable{

	public static CyclicBarrier newCyclicBarrier = new CyclicBarrier(3);
	public void run() {
		System.out.println("Number of parties required to trip the barrier = " + newCyclicBarrier.getParties());
		System.out.println("Sum of product and sum" + Computation1.product + Computation2.sum);
		
		new Thread(new Computation1()).start();
		new Thread(new Computation2()).start();
		try{
			Tester.newCyclicBarrier.await();
		} catch(InterruptedException e){
			e.printStackTrace();
		} catch(BrokenBarrierException e){
			e.printStackTrace();
		}
		
		// barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product + 
        Computation2.sum));
                 
        // Resetting the newBarrier
        newCyclicBarrier.reset();
        System.out.println("Barrier reset successful");
		
		
	}
	public static void main(String[] args) {
		new Thread(new Tester()).start();
	}

}
