package com.hsbc.srbp.commonMsg.service;

import com.hsbc.srbp.commonMsg.domain.CommonMessage;

public interface MessageProcessorService {
	
	public void process(CommonMessage msg) throws Exception;
}
