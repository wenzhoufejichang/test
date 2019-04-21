package com.hzm;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LogTest3 {

	public static void main(String[] args) {

		int[] arr = { 100, 2, -19 };
		System.out.println(get(() -> IntStream.of(arr).max().getAsInt()));
		System.out.println(get(() -> {

			int max = arr[0];
			for (int i = 1; i < arr.length; i++) {

				if (arr[i] > max) {

					max = arr[i];
				}

			}
			return max;
		}));
	}

	public static Integer get(Supplier<Integer> s) {
		return s.get();
	}
}
