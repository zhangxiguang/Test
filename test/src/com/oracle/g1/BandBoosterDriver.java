package com.oracle.g1;

import java.util.Scanner;

public class BandBoosterDriver {

	public static void main(String[] args) {
		BandBooster A = new BandBooster("Zxg");
		A.getName();
		BandBooster B = new BandBooster("Ly");
		B.getName();
		System.out.println("����������鿴�Ķ���A or B");
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
		System.out.println("���潲��ʾ"+person.name+"ÿ�����ڵ��ǹ��е����۶�");
		System.out.println(person.boxesSold);
		System.out.println("��������һ��"+person.name+"���������");
		Scanner sc=new Scanner(System.in);
		int count=sc.nextInt();
		person.boxesSold+=count;
		person.updateSales(count);
		System.out.println(person.toString());
	}
}
