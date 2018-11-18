package com.java.t3;

import java.util.ArrayList;
import java.util.Scanner;

public class StockBlock {
	private int number;
	private int price;
	private static int money = 5000;// 本金
	private static int getmoney = 0;// 获利
	private static int sotckblocknum = 0;// 当前股的顺序

	@Override
	public String toString() {
		return "StockBlock [number=" + number + ", price=" + price + "]";
	}

	public StockBlock() {
		super();
	}

	public StockBlock(int number, int price) {
		super();
		this.number = number;
		this.price = price;
	}

	private static ArrayList<StockBlock> list = new ArrayList<>();
	private static int[] mylist= {0,0,0,0,0};

	public static void main(String[] args) {
		StockBlock s1 = new StockBlock(100, 10);
		StockBlock s2 = new StockBlock(200, 13);
		StockBlock s3 = new StockBlock(50, 10);
		StockBlock s4 = new StockBlock(100, 10);
		StockBlock s5 = new StockBlock(100, 10);

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		menu();
	}

	public static void menu() {
		while (true) {
			System.out.println("当前股票信息：");
			for(int i=0;i<list.size();i++) {
				System.out.println(i+"号"+list.get(i));
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("请选择您要进行操作的股票：");
			int pd=sc.nextInt();
			System.out.println("当前股:" + list.get(pd));
			System.out.println("请输入指令:");
			String order1 = sc.next();
			if (order1.equals("buy")) {
				System.out.println("请输入数量");
				int order2 = sc.nextInt();
				if (order2 <= list.get(sotckblocknum).number) {
					money = money - order2 * list.get(sotckblocknum).price;
					list.get(sotckblocknum).number -= order2;
					if (list.get(sotckblocknum).number >= 0) {
						System.out.println("购买成功！");
						mylist[sotckblocknum]+=order2;
						System.out.println(mylist[sotckblocknum]);
						System.out.println("当前余额：" + money);
						exit();
					} else {
						System.out.println("当前股票数量已经卖光，请选择其他股票");
						exit();
					}
				} else {
					System.out.println("超出所剩股票上限！");
					exit();
				}
			} else if (order1.equals("sell")) {
				System.out.println("请输入数量");
				int order2 = sc.nextInt();
				if(mylist[sotckblocknum]>=order2) {
					System.out.println("请输入价格");
					int order3=sc.nextInt();
					getmoney=order2*order3;
					money+=getmoney;
					mylist[sotckblocknum]-=order2;
					list.get(sotckblocknum).number+=order2;
					System.out.println("您以每股"+order3+"的价格共售出"+sotckblocknum+"号股票"+order2+"股");
					System.out.println("共获益"+getmoney+"元，当前余额"+money);
					exit();
				}else {
					System.out.println("当前持有股票数量不足");
					exit();
				}
			}
		}
	}
	public static void exit() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请选择:1.返回，2.退出");
		int pd=sc.nextInt();
		if(pd==1) {
			menu();
		}else if(pd==2) {
			System.exit(0);
		}else {
			System.err.println("Error");
			exit();
		}
		
	}
}
