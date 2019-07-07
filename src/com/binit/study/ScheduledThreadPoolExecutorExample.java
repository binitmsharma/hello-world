package com.binit.study;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		Task task1 = new Task("Demo task 1");
		Task task2 = new Task("Demo task 2");
		
		executor.schedule(task1, 5, TimeUnit.SECONDS);
		executor.schedule(task2, 10, TimeUnit.SECONDS);
		
		try{
			executor.awaitTermination(1, TimeUnit.SECONDS);
		}catch(InterruptedException e){
			e.printStackTrace();
		} finally{
			executor.shutdown();
		}
	}

}
