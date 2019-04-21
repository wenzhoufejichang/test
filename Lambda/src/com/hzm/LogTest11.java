package com.hzm;

import java.util.ArrayList;
import java.util.List;

public class LogTest11 {

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

		List<String> l3 = new ArrayList<>();

		for (String s : l1) {

			if (s.length() == 3) {

				l3.add(s);
			}
		}
		List<String> l4 = new ArrayList<>();
		for (String s : l2) {

			if (s.contains("张")) {

				l4.add(s);
			}
		}

		List<String> list5 = l3.subList(0, 3);
		List<String> list6 = l4.subList(2, l4.size());
		list5.addAll(list6);
		List<Person> l = new ArrayList<>();
		for (String s : list5) {

			l.add(new Person(s));

		}

		for (Person p : l) {

			System.out.println(p);
		}

	}

}

class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
