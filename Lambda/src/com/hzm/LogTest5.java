package com.hzm;

import java.util.function.Consumer;

public class LogTest5 {

	public static void main(String[] args) {

		String[] arr = { "张三,男", "李四,女" };

		for (String s : arr) {
			get(s, (t) -> {

				String[] strings = t.split(",");
				System.out.println("姓名:" + strings[0]);

			}, (t) -> {

				String[] strings = t.split(",");
				System.out.println("性别:" + strings[1]);
			});
		}

	}

	public static void get(String name, Consumer<String> c1, Consumer<String> c2) {

		c1.andThen(c2).accept(name);

	}
}
