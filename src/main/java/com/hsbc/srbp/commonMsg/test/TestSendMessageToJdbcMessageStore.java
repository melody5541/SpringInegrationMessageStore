package com.hsbc.srbp.commonMsg.test;

import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;

public class TestSendMessageToJdbcMessageStore {


	private TestSendMessageToJdbcMessageStore() {
	}

	public static void main(final String... args) {

		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbcMessageStoreApplicationContext-outbound.xml");
		MessageChannel channel = context.getBean("inputChannel",QueueChannel.class);
		HashMap<String, Object> map = new HashMap<>();
		for(int i=1;i<11;i++){
			map.put("message_content", "message #"+i);
			channel.send(MessageBuilder.withPayload(map).setHeader("message_name", "It`s message name #"+i).build());
		}
		

	}
}
