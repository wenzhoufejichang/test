package com.hzm;

public class LogTest {

	public static void main(String[] args) {

		String s1 = "1";
		String s2 = "2";

//		log(1, new LambdaTest() {
//
//			@Override
//			public String build() {
//				// TODO Auto-generated method stub
//				return s1 + s2;
//			}
//		});
		log(1, () -> s1 + s2);

	}

	public static void log(int i, LambdaTest lt) {

		if (i == 1) {

			System.out.println(lt.build());
		}

	}

}
