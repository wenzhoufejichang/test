package com.hzm;

import java.util.function.Function;

public class LogTest8 {

	public static void main(String[] args) {

		System.out.println(get("10", (s) -> Integer.parseInt(s)));

	}

	public static int get(String s, Function<String, Integer> f) {

		return f.apply(s);

	}
}
