package com.spc.jpa.domain.encode;

import org.junit.Test;

import com.spc.jpa.AbstractIntegrationTest;
import com.spc.jpa.common.MessageUtil;

public class EncodeSHA256Test extends AbstractIntegrationTest{
	
	MessageUtil messageUtil = new MessageUtil();
	
	@Test
	public void encodeSHA265Test() {
		String testStr = "bliex";
		System.out.println(testStr);
		
		testStr = messageUtil.encodeSHA256(testStr);
		System.out.println(testStr);
    }
}
