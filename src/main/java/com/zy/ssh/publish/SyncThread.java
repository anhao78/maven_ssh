package com.zy.ssh.publish;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SyncThread implements Runnable {
	private final static Log log = LogFactory.getLog(SyncThread.class);
	public static SimpleDateFormat yyyyMMDD = new SimpleDateFormat("yyyyMMdd");
	Object object = new Object();

	public SyncThread(Object object) {
		this.object = object;
	}

	public void run() {
		int cnt = (int) object;
		for (int i = 0; i < cnt; i++) {
			doMethod(i);
		}
	}

	public synchronized void doMethod(int i) {

		System.out.println("第" + i + "次" + Thread.currentThread().getName()
				+ " 运行...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("第" + i + "次" + Thread.currentThread().getName()
				+ " 执行结束...");

	}

}
