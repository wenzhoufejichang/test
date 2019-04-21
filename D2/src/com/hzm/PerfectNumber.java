package com.hzm;

public class PerfectNumber {

	public static void main(String[] args) {

		for (int i = 1; i <= 1000; i++) {
			int sum = 0;
			for (int y = 1; y < i; y++) {

				if (i % y == 0) {

					sum += y;

				}

			}

			if (sum == i) {

				System.out.println("完数:" + i);
			}

		}

	}
}
