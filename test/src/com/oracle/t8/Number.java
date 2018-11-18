package com.oracle.t8;

public class Number extends Thread {
	PrintNumber p;
	private int number=1;
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = this.number+number;
	}

	public Number(PrintNumber p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			while(getNumber()<52) {
				System.out.print(getNumber()+" ");
				setNumber(1);
				System.out.print(getNumber()+" ");
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
