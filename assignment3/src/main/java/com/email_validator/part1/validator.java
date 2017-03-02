package com.email_validator.part1;


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
		if( domainValid(str)) {
			count++;
		}
		if( comValid(str)) {
			count++;
		}
		return count;
	}
	public static boolean atValid( String str) {
		return str.matches("[^@}@[^@]");
	}
	public static boolean pointValid( String str) {
		return str.matches("*\\.*");
	}
	public static boolean domainValid( String str) {
		return str.matches("*gmail*");
	}
	public static boolean comValid( String str) {
		return str.matches("*com");
	}
}
