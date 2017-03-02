package com.email_validator_ui.stage3.webApp;


public class validator
{
	public static int validate( String str) {
		int count = 0;
		if( atValid(str)) {
			count++;
		}
		if( pointValid(str)) {
			count++;
		}
		if( gmailValid(str)) {
			count++;
		}
		if( sizeValid(str)) {
			count++;
		}
		return count;
	}
	public static boolean atValid( String str) {
		return str.matches("[^@]*@[^@]*");
	}
	public static boolean pointValid( String str) {
		return str.matches(".*\\..*");
	}
	public static boolean gmailValid( String str) {
		return str.matches(".*gmail.com");
	}
	public static boolean sizeValid( String str) {
		return str.matches(".+");
	}
}
