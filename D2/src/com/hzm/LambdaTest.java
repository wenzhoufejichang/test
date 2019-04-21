package com.hzm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("王", 12), new Student("李", 113), new Student("王", 11));

		Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge() == 0 ? o1.getName().compareTo(o2.getName())
				: o1.getAge() - o2.getAge());
		System.out.println(list);
	}
}

class Student {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
