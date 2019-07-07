package com.binit.study;

class JoinTest01 implements Runnable {

	public void run() {
		System.out.println("JointTest01 starts");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("JointTest01 ends");
	}
}

class JoinTest02 implements Runnable {
	public void run() {
		System.out.println("JointTest02 starts");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("JoinTest02 ends");
	}
}

public class ThreadJoinTest {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new JoinTest01());
		Thread t2 = new Thread(new JoinTest02());
		t1.start();
		t1.join();
		t2.start();
		t2.join();

	}
}
