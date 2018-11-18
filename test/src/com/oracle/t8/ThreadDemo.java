package com.oracle.t8;

import javax.xml.stream.events.StartDocument;

public class ThreadDemo {

	public static void main(String[] args) {
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < args.length; i++) {
					
				}
			}
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}) .start();
		
		MyThread1 t1=new MyThread1();
		t1.start();
		MyThread2 target=new MyThread2();
		Thread t2=new Thread(target);
		t2.start();
		
	}

}
