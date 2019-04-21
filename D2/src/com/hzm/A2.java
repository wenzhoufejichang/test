package com.hzm;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class A2 {
	public static void main(String[] args) {
		try {
			A11 a = new A11();
			Thread t0 = new Thread(a);
			Thread t1 = new Thread(a);
			t0.start();
			t1.start();
			t0.join();
			t1.join();
			// System.out.println(a.getSet().size());

			ConcurrentHashMap<Integer, Integer> map = a.getC();
			KeySetView<Integer, Integer> keySet = map.keySet();
			for (Integer i : keySet) {
				Integer integer = map.get(i);
				System.out.println(i + ":" + integer);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class A11 implements Runnable {

	private Set<Integer> set = new HashSet<>();
	private ConcurrentHashMap<Integer, Integer> c = new ConcurrentHashMap<>();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			c.put(i, i);
			// set.add(i);
		}
	}

	public Set<Integer> getSet() {
		return set;
	}

	public ConcurrentHashMap<Integer, Integer> getC() {
		return c;
	}

}