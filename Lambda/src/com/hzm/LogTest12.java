package com.hzm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogTest12 {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		l1.add("张三");
		l1.add("黄真真");
		l1.add("里肆意");
		l1.add("张嘻嘻");
		l1.add("张哼1");
		List<String> l2 = new ArrayList<>();
		l2.add("吵哈哈");
		l2.add("黄知道");
		l2.add("张狠");
		l2.add("张黄");
		l2.add("张一");

		Stream<String> stream = l1.stream().filter((s) -> s.length() == 3).limit(3);

		Stream<String> skip = l2.stream().filter((t) -> t.contains("张")).skip(2);

		Stream.concat(stream, skip).forEach((t) -> System.out.println(new Person(t)));

	}

}
