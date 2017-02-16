package com.hsbc.srbp.commonMsg.service.impl;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hsbc.srbp.commonMsg.domain.CommonMessage;
import com.hsbc.srbp.commonMsg.service.MessageProcessorService;

@Component
@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, value="processorTransactionManager", readOnly=false)
public class MessageProcessorServiceImpl implements MessageProcessorService {
	private static Logger logger = Logger.getLogger(MessageProcessorServiceImpl.class);
	@Async
	public void process(CommonMessage msg) throws Exception {
		logger.info("**************sleep **************" +msg.getMap().get("message_content"));
		Thread.sleep(1000000);
		logger.info("**************wake up**************" +msg.getMap().get("message_content"));

	}

}
