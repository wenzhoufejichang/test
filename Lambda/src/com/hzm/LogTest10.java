package com.hzm;

import java.util.function.Function;

public class LogTest10 {

	public static void main(String[] args) {

		int y = get("ss,10", (s) -> {

			String string = s.split(",")[1];
			int i = Integer.parseInt(string);
			i += 100;
			return i;
		});

		System.out.println(y);

	}

	public static int get(String s, Function<String, Integer> f) {

		return f.apply(s);

	}
}
