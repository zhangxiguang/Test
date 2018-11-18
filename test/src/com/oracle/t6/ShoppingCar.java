package com.oracle.t6;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCar {
	private double money = 0;// 总价
	static int kindshop = 0;// 商品种类

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
		System.out.println("1.添加商品");
		System.out.println("2.删除商品");
		System.out.println("3.修改商品");
		System.out.println("4.查看商品");
		System.out.println("5.退出系统");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1: {
			Addshop();
			break;
		}
		case 2: {
			System.out.println("请输入商品编号");
			int num1 = sc.nextInt();
			Delshop(num1);
			break;
		}
		case 3: {
			System.out.println("请输入商品编号");
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

	public static void Addshop() { // 添加商品
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入商品编号");
		int num1 = sc.nextInt();
		System.out.println("请输入商品名称");
		String num2 = sc.next();
		System.out.println("请输入商品单价");
		double num3 = sc.nextDouble();
		System.out.println("请输入商品数量");
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
					System.out.println("该商品已存在，商品数量+1");
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

	public static void Delshop(int number) { // 删除商品
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == number) {
				System.out.println("您要删除的商品是:" + list.get(i).toString());
				System.out.println("请确认是否删除？是：y  否：n");
				Scanner sc = new Scanner(System.in);
				String pd = sc.next();
				if (pd.equals("y")) {
					list.remove(list.get(i));
					kindshop--;
					remenu();
				} else if (pd.equals("n")) {
					System.out.println("已取消操作");
					remenu();
				} else {
					System.err.println("输入错误");
					remenu();
				}
			}
		}
	}

	public static void Modshop(int number) {// 修改商品
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == number) {
				Alllist();
				System.out.println("您要修改的商品是:" + list.get(i).toString());
				System.out.println("请输入要添加的商品数量：");
				Scanner sc = new Scanner(System.in);
				int amount = sc.nextInt();
				list.get(i).setAmount(amount);
				Alllist();
				System.out.println("修改后的商品信息为：" + list.get(i).toString());
				remenu();
			}
		}
	}

	public static void Broshop() {// 查看商品
		Alllist();
		if (list.size() == 0) {
			System.out.println("当前购物车暂无商品");
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
		System.out.println("当前总价为：" + sc.getMoney());
		remenu();
	}

	public static void Alllist() { // 遍历数组
		for (int i = 0; i < list.size(); i++) {
			double price = list.get(i).getPrice();
			int amount = list.get(i).getAmount();
			list.get(i).setAllprice(price, amount);
		}
	}

	public static void remenu() { // 返回主页
		System.out.println("是否返回主页：   是：y");
		Scanner sc = new Scanner(System.in);
		String pd2 = sc.next();
		if (pd2.equals("y")) {
			menu();
		} else {
			System.err.println("输入错误");
			remenu();
		}
	}

}
