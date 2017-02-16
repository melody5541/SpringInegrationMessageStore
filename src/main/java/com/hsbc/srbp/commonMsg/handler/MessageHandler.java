package com.hsbc.srbp.commonMsg.handler;

import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import com.hsbc.srbp.commonMsg.service.MessageProcessorService;

public class MessageHandler {
	private static Logger logger = Logger.getLogger(MessageHandler.class);
	
	private MessageProcessorService messageProcessorService;
	
	public void setMessageProcessorService(MessageProcessorService messageProcessorService) {
		this.messageProcessorService = messageProcessorService;
	}

	public void hand(Message<?> message) throws Exception{
		logger.info("###################start handle message :" +message.getHeaders().get("message_name")+" #################");
		messageProcessorService.process(message);
		logger.info("###################end handle message :" +message.getHeaders().get("message_name")+" #################");
		logger.info(message);
	}
}
