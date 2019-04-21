package com.hzm;

import java.util.function.Consumer;

public class LogTest4 {

	public static void main(String[] args) {

		get("哈1", (name) -> System.out.println(name.length()));
		get("哈1", (name) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(name);
			sb.reverse();
			System.out.println(sb.toString());
		});

	}

	public static void get(String name, Consumer<String> c) {

		c.accept(name);

	}
}
