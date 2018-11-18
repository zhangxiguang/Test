package com.oracle.g1;

import java.util.Scanner;

public class BandBoosterDriver {

	public static void main(String[] args) {
		BandBooster A = new BandBooster("Zxg");
		A.getName();
		BandBooster B = new BandBooster("Ly");
		B.getName();
		System.out.println("请输入你想查看的对象，A or B");
		Scanner sc = new Scanner(System.in);
		String human = sc.nextLine();
		if (human.equals("A")) {
			Print(A);
		} else if (human.equals("B")) {
			Print(B);
		} else {
			System.err.println("Error input!");
		}
	}

	public static void Print(BandBooster person) {
		System.out.println("下面讲显示"+person.name+"每个星期的糖果盒的销售额");
		System.out.println(person.boxesSold);
		System.out.println("请输入新一周"+person.name+"的销售情况");
		Scanner sc=new Scanner(System.in);
		int count=sc.nextInt();
		person.boxesSold+=count;
		person.updateSales(count);
		System.out.println(person.toString());
	}
}
