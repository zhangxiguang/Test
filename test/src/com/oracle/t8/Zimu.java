package com.oracle.t8;

public class Zimu extends Thread{
	PrintNumber p;
	private int number=65;
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = this.number+number;
	}

	public Zimu(PrintNumber p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		try {
			sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (p) {
			while(getNumber()<91) {
				char c=(char)getNumber();
				System.out.print(c+" ");
				setNumber(1);
				p.notifyAll();
				try {
					p.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
