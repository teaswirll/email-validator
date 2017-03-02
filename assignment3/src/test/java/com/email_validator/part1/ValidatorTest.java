package com.email_validator.part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void testValidEamil() {
		assertEquals(2, validator.validate("abc@gmail.com"));
	}
	
	@Test
	public void testNotValid() {
		assertEquals(0, validator.validate("a@bc@gmailcom"));
	}
	
	@Test
	public void testAtValid() {
		assertEquals(1, validator.validate("abc@gmailcom"));
	}
	
	@Test
	public void testDotValid() {
		assertEquals(1, validator.validate("ab@cgma@il.com"));
	}
	
	@Test
	public void testValid() {
		assertEquals(2, validator.validate(".@."));
	}
}
