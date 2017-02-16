package com.hsbc.srbp.commonMsg.test;

import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.serializer.Serializer;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.support.MessageBuilder;

import com.hsbc.srbp.commonMsg.domain.CommonMessage;

public class TestJdbcMessageStore {


	private TestJdbcMessageStore() {
	}

	public static void main(final String... args) {

		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbcMessageStoreApplicationContext.xml");
		MessageChannel channel = context.getBean("inputChannel",QueueChannel.class);
		CommonMessage message = new CommonMessage();
		HashMap<String, Object> map = new HashMap<>();
		for(int i=1;i<11;i++){
			map.put("message_content", "message #"+i);
			message.setMap(map);
			channel.send(MessageBuilder.withPayload(message).setHeader("message_name", "message!!! #"+i).build());
		}
		

	}
}
