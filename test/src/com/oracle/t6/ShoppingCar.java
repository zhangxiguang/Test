package com.oracle.t6;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCar {
	private double money = 0;// �ܼ�
	static int kindshop = 0;// ��Ʒ����

	public double getMoney() {
		return money;
	}

	public void setMoney(double allprice) {
		this.money += allprice;
	}

	static ArrayList<Product> list = new ArrayList<>();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		System.out.println("1.�����Ʒ");
		System.out.println("2.ɾ����Ʒ");
		System.out.println("3.�޸���Ʒ");
		System.out.println("4.�鿴��Ʒ");
		System.out.println("5.�˳�ϵͳ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1: {
			Addshop();
			break;
		}
		case 2: {
			System.out.println("��������Ʒ���");
			int num1 = sc.nextInt();
			Delshop(num1);
			break;
		}
		case 3: {
			System.out.println("��������Ʒ���");
			int num1 = sc.nextInt();
			Modshop(num1);
			break;
		}
		case 4: {
			Broshop();
			break;
		}
		case 5: {
			System.exit(0);
			break;
		}
		default: {
			remenu();
			break;
		}

		}
	}

	public static void Addshop() { // �����Ʒ
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ʒ���");
		int num1 = sc.nextInt();
		System.out.println("��������Ʒ����");
		String num2 = sc.next();
		System.out.println("��������Ʒ����");
		double num3 = sc.nextDouble();
		System.out.println("��������Ʒ����");
		int num4 = sc.nextInt();
		boolean flag = true;
		if (kindshop == 0) {
			Product product = new Product(num1, num2, num3, num4);
			list.add(product);
			kindshop++;
			remenu();
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (num1 == list.get(i).getNumber()) {
					System.out.println("����Ʒ�Ѵ��ڣ���Ʒ����+1");
					list.get(i).setAmount(1);
					flag = false;
					remenu();
				}
			}
			if (flag == true) {
				Product product = new Product(num1, num2, num3, num4);
				list.add(product);
				kindshop++;
				remenu();
			}
		}

	}

	public static void Delshop(int number) { // ɾ����Ʒ
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == number) {
				System.out.println("��Ҫɾ������Ʒ��:" + list.get(i).toString());
				System.out.println("��ȷ���Ƿ�ɾ�����ǣ�y  ��n");
				Scanner sc = new Scanner(System.in);
				String pd = sc.next();
				if (pd.equals("y")) {
					list.remove(list.get(i));
					kindshop--;
					remenu();
				} else if (pd.equals("n")) {
					System.out.println("��ȡ������");
					remenu();
				} else {
					System.err.println("�������");
					remenu();
				}
			}
		}
	}

	public static void Modshop(int number) {// �޸���Ʒ
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == number) {
				Alllist();
				System.out.println("��Ҫ�޸ĵ���Ʒ��:" + list.get(i).toString());
				System.out.println("������Ҫ��ӵ���Ʒ������");
				Scanner sc = new Scanner(System.in);
				int amount = sc.nextInt();
				list.get(i).setAmount(amount);
				Alllist();
				System.out.println("�޸ĺ����Ʒ��ϢΪ��" + list.get(i).toString());
				remenu();
			}
		}
	}

	public static void Broshop() {// �鿴��Ʒ
		Alllist();
		if (list.size() == 0) {
			System.out.println("��ǰ���ﳵ������Ʒ");
			remenu();
		}
		ShoppingCar sc = new ShoppingCar();
		for (int i = 0; i < list.size(); i++) {
			double price = list.get(i).getPrice();
			int amount = list.get(i).getAmount();
			list.get(i).setAllprice(price, amount);
			sc.setMoney(list.get(i).getAllprice());
			System.out.println(list.get(i).toString());
		}
		System.out.println("��ǰ�ܼ�Ϊ��" + sc.getMoney());
		remenu();
	}

	public static void Alllist() { // ��������
		for (int i = 0; i < list.size(); i++) {
			double price = list.get(i).getPrice();
			int amount = list.get(i).getAmount();
			list.get(i).setAllprice(price, amount);
		}
	}

	public static void remenu() { // ������ҳ
		System.out.println("�Ƿ񷵻���ҳ��   �ǣ�y");
		Scanner sc = new Scanner(System.in);
		String pd2 = sc.next();
		if (pd2.equals("y")) {
			menu();
		} else {
			System.err.println("�������");
			remenu();
		}
	}

}
