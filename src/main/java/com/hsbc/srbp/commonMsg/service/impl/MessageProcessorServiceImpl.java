package com.hsbc.srbp.commonMsg.service.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hsbc.srbp.commonMsg.service.MessageProcessorService;

@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, value="processorTransactionManager", readOnly=false)
public class MessageProcessorServiceImpl implements MessageProcessorService {
	private static Logger logger = Logger.getLogger(MessageProcessorServiceImpl.class);
	
	@Async
	@SuppressWarnings("unchecked")
	public void process(Message<?> message) throws Exception {
		if(message.getPayload() instanceof HashMap<?,?>){
		HashMap<String,Object> payloadMap = new HashMap<>();
		payloadMap=(HashMap<String, Object>) message.getPayload();
		logger.info("**************sleep **************" +payloadMap.get("message_content"));
		Thread.sleep(1000000);
		logger.info("**************wake up**************" +payloadMap.get("message_content"));
		}else{
			logger.error("message is not a instance of CommenMessage");
			throw new RuntimeException("message is not a instance of CommenMessage");
		}

	}

}
