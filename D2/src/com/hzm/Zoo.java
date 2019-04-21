package com.hzm;

public class Zoo {

	// private AtomicInteger number = new AtomicInteger(100);
	private int number = 0;

	public static void main(String[] args) {
		Zoo z = new Zoo();
		new Thread(new Z(z), "甲").start();
		new Thread(new Z(z), "乙").start();
	}

	// public int getNumber() {
	// return number.addAndGet(-10);
	// }
	public int getNumber() {

		//int temp=number
		//number=number+1
		//return temp
		return number++;
	}

}

class Z implements Runnable {

	private Zoo z;

	public Z(Zoo z) {
		super();
		this.z = z;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {

			System.out.println(Thread.currentThread().getName() + z.getNumber());

		}

	}

}
