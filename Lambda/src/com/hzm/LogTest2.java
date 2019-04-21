package com.hzm;

import java.util.function.Supplier;

public class LogTest2 {

	public static void main(String[] args) {

		String s = get(() -> "haha");
		
		System.out.println(s);
		
	}

	public static String get(Supplier<String> s) {
		return s.get();
	}
}
