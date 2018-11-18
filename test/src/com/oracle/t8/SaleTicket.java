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
		
		Window win1=new Window("一号窗口",s);
		Window win2=new Window("二号窗口",s);
		Window win3=new Window("三号窗口",s);
		Window win4=new Window("四号窗口",s);
		Window win5=new Window("五号窗口",s);
		
		win1.start();
		win2.start();
		win3.start();
		win4.start();
		win5.start();
		
	
	
	
	}
	
}
