package com.hzm;

import java.util.function.Predicate;

public class LogTest6 {

	public static void main(String[] args) {

		String[] arr = { "fdgaf", "dd2df", "fdga" };

		for (String s : arr) {

			boolean b = get(s, (String t) -> t.length()>4, (String t) -> t.contains("a"));
			System.out.println(b);
		}

	}

	public static boolean get(String name, Predicate<String> p1, Predicate<String> p2) {
		return p1.and(p2).test(name);

	}
}
