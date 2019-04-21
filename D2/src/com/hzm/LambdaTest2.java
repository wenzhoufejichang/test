package com.hzm;

public class LambdaTest2 {

	public static void main(String[] args) {
		String s = "adfd";

		System.out.println(change(s, (a) -> a.toUpperCase()));
		System.out.println(sum(100L, 200L, (a, b) -> a + b));
		System.out.println(sum(100L, 200L, (a, b) -> a * b));
	}

	public static String change(String s, Transformation t) {

		return t.Tra(s);
	}

	public static Long sum(Long l1, Long l2, Transformation2<Long, Long> t) {

		return t.get(l1, l2);
	}

	public static String product(String s, Transformation t) {

		return t.Tra(s);
	}

}

@FunctionalInterface
interface Transformation {

	public abstract String Tra(String s);

}

@FunctionalInterface
interface Transformation2<T, R> {

	public abstract R get(T t1, T t2);

}
