package com.hzm;

public class SingleOne {

	public static void main(String[] args) {
		AS as = AS.get();
	}
	
	
}

class AS {

	private static AS a;

	private AS() {

	}

	public static AS get() {

		if (a == null) {
			synchronized (AS.class) {

				if (a == null) {

					a = new AS();
				}
			}
		}

		return a ;

	}
}