package com.hsbc.srbp.commonMsg.service;

import org.springframework.integration.Message;

public interface MessageProcessorService {
	
	public void process(Message<?> message) throws Exception;
}
