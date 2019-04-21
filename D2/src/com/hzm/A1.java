package com.hzm;

public class A1 {
	public static void main(String[] args) {
		
		int aaa=1,b=2;
		
		System.out.println(aaa+b+"");
//		A a = new A();
//
//		new Thread(a).start();
//
//		while (true)
//			if ("2".equals(a.getSs())) {
//				System.out.println("----");
//				break;
//
//			}

		
		
		
		
		
		
		
	}
}

class A implements Runnable {

	private  String ss = "1";

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSs("2");
		System.out.println(Thread.currentThread().getName() + getSs());

	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

}