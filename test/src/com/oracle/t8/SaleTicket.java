package com.oracle.t8;

public class SaleTicket {
	private int ticket=100;
	private int number=1;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = this.number+number;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int number) {
		this.ticket = this.ticket-number;
	}
	
	public static void main(String[] args) {
		SaleTicket s=new SaleTicket();
		
		Window win1=new Window("һ�Ŵ���",s);
		Window win2=new Window("���Ŵ���",s);
		Window win3=new Window("���Ŵ���",s);
		Window win4=new Window("�ĺŴ���",s);
		Window win5=new Window("��Ŵ���",s);
		
		win1.start();
		win2.start();
		win3.start();
		win4.start();
		win5.start();
		
	
	
	
	}
	
}
