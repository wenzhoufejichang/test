package com.hzm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogTest9 {

	public static void main(String[] args) {
		String[] s1 = { "12", "2", "haha" };
		String[] s2 = { "12", "2", "haha" };
		String[] strings = Stream.concat(Stream.of(s1), Stream.of(s2)).toArray(String[]::new);

		System.out.println(Arrays.toString(strings));

		List<String> list = Stream.concat(Stream.of(s1), Stream.of(s2)).collect(Collectors.toList());
		String[] array = list.toArray(new String[0]);
		System.out.println(Arrays.toString(array));
	}

}
