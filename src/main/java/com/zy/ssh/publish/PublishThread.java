package com.zy.ssh.publish;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class PublishThread implements Runnable {
	Object object = new Object();
	private ThreadPoolTaskExecutor publishThreadPool;
	
	public ThreadPoolTaskExecutor getPublishThreadPool() {
		return publishThreadPool;
	}

	public void setPublishThreadPool(ThreadPoolTaskExecutor publishThreadPool) {
		this.publishThreadPool = publishThreadPool;
	}

	public PublishThread() {
		super();
	}

	public PublishThread(Object object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		int cnt = (int) object;
		for (int i = 0; i < cnt; i++) {
			//doMethod(i);
			 doMethod1(i);
		}
	}

	// 同步方法, 当前对象（this）作为标记对象
	public synchronized void doMethod(int i) {

		System.out.println("第"+i+"次"+Thread.currentThread().getName() + " 运行...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("第"+i+"次"+Thread.currentThread().getName() + " 执行结束...");

	}

	// 不同步
	public void doMethod1(int i) {

		System.out.println("第"+i+"次"+Thread.currentThread().getName() + " 运行...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("第"+i+"次"+Thread.currentThread().getName() + " 执行结束...");

	}

}
