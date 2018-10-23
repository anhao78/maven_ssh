package com.zy.ssh.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class DistCheckJob extends QuartzJobBean {
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		DistCheckUp distCheckUp = new DistCheckUp();
		distCheckUp.checkUp();
	}
}