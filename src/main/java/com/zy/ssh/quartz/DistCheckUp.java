package com.zy.ssh.quartz;


import java.util.Date;

import org.apache.log4j.Logger;

public class DistCheckUp {
	private Logger log = Logger.getLogger(DistCheckUp.class);

	public void checkUp() {
		Date date=new Date();
		log.info("===========dist check up start==========:"+date);
	}

}
