package com.zy.ssh.publish;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SyncThreadPool {
	private final static Log log = LogFactory.getLog(SyncThreadPool.class);
	static int corePoolSize = 60;
	static int maximumPoolSize = 100;
	static int keepAliveTime = 20;
	// static long waitTime = 10000;
	public static ThreadPoolExecutor workers;
	static int QueueSize = Integer.MAX_VALUE;

	public static void init() {
		try {
			String tmpCoreSize = "100";
			String tmpMaxSize = "150";
			if (tmpCoreSize != null && !"".equals(tmpCoreSize)) {
				corePoolSize = Integer.parseInt(tmpCoreSize);
			}
			if (tmpMaxSize != null && !"".equals(tmpMaxSize)) {
				maximumPoolSize = Integer.parseInt(tmpMaxSize);
			}
		} catch (Throwable e) {
			corePoolSize = 60;
			log.error("parseInt Error,default corePoolSize=60");
		}
		log.info("corePoolSize:" + corePoolSize + "   maximumPoolSize"
				+ maximumPoolSize);
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(
				QueueSize);
		RejectedExecutionHandler handler = new RejectedExecutionHandler() {
			public void rejectedExecution(Runnable r,
					ThreadPoolExecutor executor) {
				// TODO 一般情况下，不可能进入此处
				// 如果池中队列已满、线程数等于maximumPoolSize，则直接让这个多出的线程自己跑（run）掉
				log.error("rejectedExecution[AtvCnt="
						+ executor.getActiveCount() + ",Q.Size="
						+ executor.getQueue().size() + "]");
				r.run();
			}
		};

		if (workers == null) {
			log.info("SyncThreadPool .........init workers.....");
			workers = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
					keepAliveTime, TimeUnit.SECONDS, workQueue, handler);
		}
	}

	public synchronized static void addTask(Object object) {
		if (workers == null)
			init();
		log.info("addTask[AtvCnt=" + workers.getActiveCount() + ",Q.Size="
				+ workers.getQueue().size() + "]-->" + object);
		workers.execute(new SyncThread(object));
	}
}

