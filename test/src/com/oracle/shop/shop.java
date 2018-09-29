package com.oracle.shop;

import java.util.Scanner;

public class shop {
	static String adminname = "admin";
	static String adminpsd = "123";
	static int a = 0;
	static int b = 0;
	static int c = 0;
	static int d = 0;
	static int e = 0;
	static int f = 0;
	static int g = 0;
	static int h = 0;
	static String[] shopmz = new String[1000];// 定义商品名字数组
	static int[] shopbh = new int[1000];// 定义商品编号数组
	static int[] shopjg = new int[1000];// 定义商品价格数组
	static int[] shopsl = new int[1000];// 定义商品数量数组
	static String[] shopcd = new String[1000];// 定义商品产地数组

	static String[] usermz = new String[1000];// 定义用户信息数组
	static String[] userbh = new String[1000];// 定义用户信息数组
	static String[] userjg = new String[1000];// 定义用户信息数组
	static String[] usersl = new String[1000];// 定义用户信息数组

	public static void main(String[] args) {
		// boolean flag = false;
		login();
	}

	public static void login() {
		// boolean flag=false;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入管理员账号:");
		String input = sc.next();
		System.out.println("请输入管理员密码:");
		String input2 = sc.next();
		if (input.equals(adminname) && input2.equals(adminpsd)) {
			System.out.println("恭喜！登陆成功！");
			// flag=true;
			menu();
		} else {
			System.out.println("账号或密码错误。");
		}
	}

	public static void menu() {
		System.out.println("请选择功能:");
		System.out.println("1.商品管理");
		System.out.println("2.用户管理");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			shop();
			break;
		case 2:
			user();
			break;
		}
	}

	public static void shop() { // 商品管理界面
		System.out.println("**************************");
		System.out.println("请选择功能:");
		System.out.println("1.添加商品");
		System.out.println("2.删除商品");
		System.out.println("3.修改商品");
		System.out.println("4.查看商品");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			addshop();
			break;
		case 2:
			delshop();
			break;
		case 3:
			modshop();
			break;
		case 4:
			broshop();
			break;
		}

	}

	public static void addshop() { // 添加商品
		System.out.println("请输入以下信息：");
		System.out.println("1.商品名称     2.商品编号    3.商品价格    4.商品数量     ");
		System.out.println("1.商品名称：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		shopmz[a] = name;
		a++;
		System.out.println("2.商品编号：");
		String bh = sc.next();
		shopbh[b] = bh;
		b++;
		System.out.println("3.商品价格：");
		String jg = sc.next();
		shopjg[c] = jg;
		c++;
		System.out.println("4.商品数量：");
		String sl = sc.next();
		shopsl[d] = sl;
		d++;
		System.out.println("输入成功，请问是否返回? 确定请按y，  继续输入请按n");
		String pd = sc.next();
		boolean flag = true;
		while (flag == true) {
			if (pd.equals("y")) {
				shop();
				flag = false;
			} else if (pd.equals("n")) {
				addshop();
				flag = false;
			} else {
				System.out.println("输入错误,请重新输入");
				pd = sc.next();
				continue;
			}
		}
	}

	public static void delshop() { // 删除商品
		System.out.println("请输入选择删除商品的名称或者商品编号!");
		System.out.println("选择商品名称请按y，选择商品编号请按n");
		Scanner sc = new Scanner(System.in);
		String pd = sc.next();
		boolean flag = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		while (flag == true) {
			if (pd.equals("y")) {
				System.out.println("请输入您要删除的商品名称：");
				String name = sc.next();
				for (int i = 0; i < shopmz.length; i++) {
					while (flag2 == true) {
						if (name.equals(shopmz[i])) {
							System.out.println("您要删除的商品信息为：");
							System.out.println("商品名称:" + shopmz[i] + "商品编号:"
									+ shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
									+ shopsl[i]);
							System.out.println("请确认是否删除：确定请按y 取消并返回请按n");
							String pd2 = sc.next();
							while (flag3 == true) {
								if (pd2.equals("y")) {
									shopmz[i] = null;
									shopbh[i] = null;
									shopjg[i] = null;
									shopsl[i] = null;
									System.out.println("商品已删除，继续删除请按y，返回请按n");
									String pd3 = sc.next();
									while (flag4 = true) {
										if (pd3.equals("y")) {
											delshop();
											flag4 = false;
										} else if (pd3.equals("n")) {
											shop();
											flag4 = false;
										} else {
											System.out.println("输入错误,请重新输入");
											pd3 = sc.next();
											continue;
										}
									}
								} else if (pd2.equals("n")) {
									shop();
									flag3 = false;
								} else {
									System.out.println("输入错误,请重新输入");
									pd2 = sc.next();
									continue;
								}
							}
						} else {
							System.out.println("输入错误,请重新输入");
							pd = sc.next();
							continue;
						}
					}
				}
			} else if (pd.equals("n")) {
				System.out.println("请输入您要删除的商品编号：");
				String name2 = sc.next();
				for (int i = 0; i < shopbh.length; i++) {
					while (flag2 == true) {
						if (name2.equals(shopbh[i])) {
							System.out.println("您要删除的商品信息为：");
							System.out.println("商品名称:" + shopmz[i] + "商品编号:"
									+ shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
									+ shopsl[i]);
							System.out.println("请确认是否删除：确定请按y 取消并返回请按n");
							String pd2 = sc.next();
							while (flag3 == true) {
								if (pd2.equals("y")) {
									shopmz[i] = null;
									shopbh[i] = null;
									shopjg[i] = null;
									shopsl[i] = null;
									System.out.println("商品已删除，继续删除请按y，返回请按n");
									String pd3 = sc.next();
									while (flag4 = true) {
										if (pd3.equals("y")) {
											delshop();
											flag4 = false;
										} else if (pd3.equals("n")) {
											shop();
											flag4 = false;
										} else {
											System.out.println("输入错误,请重新输入");
											pd3 = sc.next();
											continue;
										}
									}
								} else if (pd2.equals("n")) {
									shop();
									flag3 = false;
								} else {
									System.out.println("输入错误,请重新输入");
									pd2 = sc.next();
									continue;
								}
							}
						} else {
							System.out.println("输入错误,请重新输入");
							pd = sc.next();
							continue;
						}
					}
				}
			}

			else {
				System.out.println("输入错误,请重新输入");
				pd = sc.next();
				continue;
			}
		}
	}

	public static void modshop() { // 修改商品
		System.out.println("123");
	}

	public static void broshop() { // 查看商品
		System.out.println("123");
	}

	public static void user() { // 用户管理界面
		System.out.println("**************************");
		System.out.println("请选择功能:");
		System.out.println("1.添加用户");
		System.out.println("2.删除用户");
		System.out.println("3.修改用户");
		System.out.println("4.查看用户");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			adduser();
			break;
		case 2:
			deluser();
			break;
		case 3:
			moduser();
			break;
		case 4:
			brouser();
			break;
		}
	}

	public static void adduser() {
		System.out.println("123");
	}

	public static void deluser() {
		System.out.println("123");
	}

	public static void moduser() {
		System.out.println("123");
	}

	public static void brouser() {
		System.out.println("123");
	}

}
