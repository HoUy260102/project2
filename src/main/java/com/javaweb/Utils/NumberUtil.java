package com.javaweb.Utils;

public class NumberUtil {
	public static boolean checkNumber(String s) {
		try {
			Integer n = Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.getStackTrace();
			return false;
		}
	}
}
