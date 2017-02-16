package com.hsbc.srbp.commonMsg.test;

import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;

public class TestListenJdbcMessageStore {


	private TestListenJdbcMessageStore() {
	}

	public static void main(final String... args) {

		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbcMessageStoreApplicationContext-inbound.xml");

	}
}
