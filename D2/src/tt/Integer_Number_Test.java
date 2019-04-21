package tt;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Integer_Number_Test {
	public static void main(String[] args) {

		int[] arr = { 1, 4, 1, 4, 2, 5, 4, 5, 8, 7, 8, 77, 88, 5, 4, 9, 6, 2, 4, 1, 5 };
		Integer_Number.print(arr);
	}
}

class Integer_Number {

	public static void print(int[] number) {
		Map<String, Integer> map = new HashMap<>();

		IntStream.of(number).forEach((value) -> {

			if (map.containsKey(String.valueOf(value))) {
				Integer integer = map.get(String.valueOf(value));
				map.put(String.valueOf(value), integer + 1);
			} else {
				map.put(String.valueOf(value), 1);

			}

		});

		Set<String> set = map.keySet();
		for (String s : set) {

			System.out.println(s + "出现" + map.get(s));
		}

	}
}