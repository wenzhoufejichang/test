package com.hzm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LogTest7 {

	public static void main(String[] args) {

		String[] arr = { "张三,男", "李四dd,女", "张三,女" };

		List<String> list = get(arr, (s) -> {

			String[] strings = s.split(",");
			return strings[0].length() == 4 && strings[1].equals("女");
		});

		System.out.println(list);

	}

	public static List<String> get(String[] arr, Predicate<String> p) {

		List<String> list = new ArrayList<>();

		for (String s : arr) {

			if (p.test(s)) {

				list.add(s);
			}

		}

		return list;

	}
}
