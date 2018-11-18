package com.oracle.t8;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("haha~");
		}
	}

}
