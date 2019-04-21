package com.hzm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class DemoPrint {
	public static void main(String[] args) throws InterruptedException {

//		ReadWriteLock l = new ReentrantReadWriteLock();
//		Lock writeLock = l.writeLock();
		Print p = new Print();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 4; i++)
					p.pb();

			}

		}, "B").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 4; i++)
					p.pa();

			}

		}, "A").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 4; i++)
					p.pc();

			}

		}, "C").start();

	}
}

class Print {
	private Lock l = new ReentrantLock();
	private Condition c1 = l.newCondition();
	private Condition c2 = l.newCondition();
	private Condition c3 = l.newCondition();
	private int i = 1;

	public void pa() {

		try {
			l.lock();
			if (i != 1) {

				c1.await();
			}
			for (int a = 1; a <= 2; a++) {
				System.out.println(Thread.currentThread().getName());
			}
			i = 2;
			c2.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause

			l.unlock();
		}

	}

	public void pb() {

		try {
			l.lock();
			if (i != 2) {

				c2.await();
			}
			for (int a = 1; a <= 3; a++) {
				System.out.println(Thread.currentThread().getName());
			}
			i = 3;
			c3.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause

			l.unlock();
		}

	}

	public void pc() {

		try {
			l.lock();
			if (i != 3) {

				c3.await();
			}
			for (int a = 1; a <= 4; a++) {
				System.out.println(Thread.currentThread().getName());
			}
			i = 1;
			c1.signal();
			System.out.println("------");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause

			l.unlock();
		}

	}

}