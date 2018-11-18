package com.java.t3;

import java.util.ArrayList;
import java.util.Scanner;

public class StockBlock {
	private int number;
	private int price;
	private static int money = 5000;// ����
	private static int getmoney = 0;// ����
	private static int sotckblocknum = 0;// ��ǰ�ɵ�˳��

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
			System.out.println("��ǰ��Ʊ��Ϣ��");
			for(int i=0;i<list.size();i++) {
				System.out.println(i+"��"+list.get(i));
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("��ѡ����Ҫ���в����Ĺ�Ʊ��");
			int pd=sc.nextInt();
			System.out.println("��ǰ��:" + list.get(pd));
			System.out.println("������ָ��:");
			String order1 = sc.next();
			if (order1.equals("buy")) {
				System.out.println("����������");
				int order2 = sc.nextInt();
				if (order2 <= list.get(sotckblocknum).number) {
					money = money - order2 * list.get(sotckblocknum).price;
					list.get(sotckblocknum).number -= order2;
					if (list.get(sotckblocknum).number >= 0) {
						System.out.println("����ɹ���");
						mylist[sotckblocknum]+=order2;
						System.out.println(mylist[sotckblocknum]);
						System.out.println("��ǰ��" + money);
						exit();
					} else {
						System.out.println("��ǰ��Ʊ�����Ѿ����⣬��ѡ��������Ʊ");
						exit();
					}
				} else {
					System.out.println("������ʣ��Ʊ���ޣ�");
					exit();
				}
			} else if (order1.equals("sell")) {
				System.out.println("����������");
				int order2 = sc.nextInt();
				if(mylist[sotckblocknum]>=order2) {
					System.out.println("������۸�");
					int order3=sc.nextInt();
					getmoney=order2*order3;
					money+=getmoney;
					mylist[sotckblocknum]-=order2;
					list.get(sotckblocknum).number+=order2;
					System.out.println("����ÿ��"+order3+"�ļ۸��۳�"+sotckblocknum+"�Ź�Ʊ"+order2+"��");
					System.out.println("������"+getmoney+"Ԫ����ǰ���"+money);
					exit();
				}else {
					System.out.println("��ǰ���й�Ʊ��������");
					exit();
				}
			}
		}
	}
	public static void exit() {
		Scanner sc=new Scanner(System.in);
		System.out.println("��ѡ��:1.���أ�2.�˳�");
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
