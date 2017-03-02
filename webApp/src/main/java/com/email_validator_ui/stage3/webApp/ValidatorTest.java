package com.email_validator_ui.stage3.webApp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void testValidEamil() {
		assertEquals(4, validator.validate("abc@gmail.com"));
	}
	
	@Test
	public void testNotValid() {
		assertEquals(1, validator.validate("a@bc@gmailcom"));
	}
	
	@Test
	public void testAtValid() {
		assertEquals(2, validator.validate("abc@gmailcom"));
	}
	
	@Test
	public void testDotValid() {
		assertEquals(2, validator.validate("ab@cgma@il.com"));
	}
	
	@Test
	public void testNotGmailValid() {
		assertEquals(3, validator.validate(".@."));
	}
	
	@Test
	public void testSizeNotValid() {
		assertEquals(0, validator.validate(""));
	}
	
	@Test
	public void testGmailNotValid() {
		assertEquals(3, validator.validate("123abc@msn.ca"));
	}
}