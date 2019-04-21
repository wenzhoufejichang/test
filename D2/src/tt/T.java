package tt;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class T {
	public static void main(String[] args) {

		Map<Integer, User> map = new HashMap<>();
		map.put(1, new User("张飞", 20));
		map.put(2, new User("黄", 11));
		map.put(3, new User("a", 11));
		map.put(4, new User("李", 14));
		map.put(5, new User("张飞", 10));
		Set<Entry<Integer, User>> set = map.entrySet();

		TreeSet<Entry<Integer, User>> treee = new TreeSet<>(new Comparator<Entry<Integer, User>>() {

			@Override
			public int compare(Entry<Integer, User> o2, Entry<Integer, User> o1) {
				// TODO Auto-generated method stub
				int number = o1.getValue().getAge() - o2.getValue().getAge();

				return number == 0 ? o1.getValue().getName().compareTo(o2.getValue().getName()) : number;
			}
		});
		for (Entry<Integer, User> e : set) {

			treee.add(e);

		}

		map = new LinkedHashMap<>();

		for (Entry<Integer, User> e : treee) {
			map.put(e.getKey(), e.getValue());
		}

		System.out.println(map);
	}

}

class User {

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

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}