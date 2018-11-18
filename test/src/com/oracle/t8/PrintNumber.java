package com.oracle.t8;

public class PrintNumber {

	public static void main(String[] args) {
		PrintNumber p = new PrintNumber();
		Number b = new Number(p);
		Zimu z = new Zimu(p);
		
		b.start();
		z.start();
	}
}
