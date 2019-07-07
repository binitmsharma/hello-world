package com.binit.study;

import java.util.Date;

public class Task implements Runnable{
	private String name;
	
	Task(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void run(){
		System.out.println("Doing a tash during : " + name + "- Time - " + new Date() );
	}

}
