package com.binit.study;

import java.util.concurrent.BrokenBarrierException;

public class Computation1 implements Runnable{

	public static int product  = 0;
	
	public void run(){
		product = 2 * 3;
		try {
			Tester.newCyclicBarrier.await();
		} catch(InterruptedException e){
			e.printStackTrace();
		} catch(BrokenBarrierException e){
			e.printStackTrace();
		}
	}

}
