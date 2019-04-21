package tt;

import java.util.concurrent.CountDownLatch;

public class CCCC {
	public static void main(String[] args) {
		CountDownLatch c = new CountDownLatch(1);
		A a = new A(c);
		B b = new B(c, a);
		new Thread(a, "a号").start();
		new Thread(b, "b号").start();
		new Thread(b, "c号").start();
		// 测试git远端拉去
		// 同步到远端会发生冲突
		// 同步到远端会发生冲突
		// 同步到远端会发生冲突

		// 修改

		// 12
	//再次演示
	}
}

class A implements Runnable {

	// 12
	private CountDownLatch c;
	private Integer number = 0;

	public A(CountDownLatch c) {
		super();
		this.c = c;
	}

	public Integer getNumber() {
		// 13
		return number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1000);

				number++;
				System.out.println(Thread.currentThread().getName() + number);
				if (number.intValue() == 5) {

					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		c.countDown();
	}

}

class B implements Runnable {

	private CountDownLatch c;
	private A a;

	public B(CountDownLatch c, A a) {
		super();
		this.c = c;
		this.a = a;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			c.await();
			System.out.println(Thread.currentThread().getName() + a.getNumber());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
