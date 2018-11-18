package com.java.t3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunwaySimulator {
	private static int num = 1;// 机场跑道
	private static ArrayList flylist = new ArrayList<>(); // 天上的飞机
	private static ArrayList landlist = new ArrayList<>();// 地上的飞机
	private static int flylv=0;  //起飞优先级
	private static int landlv=1; //降落优先级

	public static void main(String[] args) {
		flylist.add(1);
		flylist.add(3);
		flylist.add(5);

		landlist.add(2);
		landlist.add(4);
		landlist.add(6);

		menu();
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入您的指令：");
			String order = sc.next();
			if (order.equals("takeoff")) {
				if (num == 1) { // 跑道空闲
					System.out.println("当前跑道空闲，可以起飞");
					System.out.println("请输入航班号:");
					int landnum = sc.nextInt();
					System.out.println("请输入下一步指令：");
					String order2 = sc.next();
					if (order2.equals("next")) {
						for (int i = 0; i < landlist.size(); i++) {
							if (landnum == (int) landlist.get(i)) {
								num--;
								System.out.println("航班号:" + (int) landlist.get(i) + "已经起飞");
								landlist.remove(landnum);
								num++;
							}
						}
					}
				} else {
					System.out.println("当前跑道繁忙，不能执行操作！");
					menu();
				}
			} else if (order.equals("land")) {
				if (num == 1) { // 跑道空闲
					System.out.println("当前跑道空闲，可以降落");
					System.out.println("请输入航班号:");
					int landnum = sc.nextInt();
					System.out.println("请输入下一步指令：");
					String order2 = sc.next();
					if (order2.equals("next")) {
						for (int i = 0; i < flylist.size(); i++) {
							if (landnum == (int) landlist.get(i)) {
								num--;
								System.out.println("航班号:" + (int) flylist.get(i) + "已经起飞");
								flylist.remove(landnum);
								num++;
							}
						}
					}
				} else {
					System.out.println("当前跑道繁忙，不能执行操作！");
					menu();
				}
			}
		}
	}
}
