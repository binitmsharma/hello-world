package com.binit.study;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Computation2 implements Runnable{
	
	public static int sum = 0;
	public void run(){
		sum = 10 + 20;
		try {
			Tester.newCyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
		} catch(InterruptedException e){
			e.printStackTrace();
		} catch(BrokenBarrierException e){
			e.printStackTrace();
		} catch(TimeoutException e){
			e.printStackTrace();
		}
	}

}
