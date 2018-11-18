package com.oracle.t8;

public class Window extends Thread {
	SaleTicket s;
	private String winname;
	

	public String getWinname() {
		return winname;
	}

	public void setWinname(String winname) {
		this.winname = winname;
	}

	public Window(String name, SaleTicket s) {
		this.winname = name;
		this.s = s;
	}

	@Override
	public void run() {
		while (s.getTicket() > 0) {
			sale();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void sale() {
		synchronized (s) {
			if (s.getTicket() > 0) {
				System.out.println("��ǰʣ��Ʊ����" + s.getTicket());
				s.setTicket(1);
				System.out.println(getWinname() + "�۳�һ��Ʊ,Ŀǰʣ�ࣺ" + s.getTicket() + "Ʊ��:" + s.getNumber());
				s.setNumber(1);
			}
		}
	}
}
