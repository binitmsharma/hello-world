package com.binit.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	
	final int corePoolSize = 5;
	final int maxPoolSize = 10;
	long keepAliveTime = 5000;
	
	ExecutorService newThreadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize,keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
			

}
