package com.java.t3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TheOne implements Comparator<String> {
	static TreeMap<String, String> map = new TreeMap<>();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		System.out.println("您可以进行以下操作:");
		System.out.println("1.添加student");
		System.out.println("2.移除student");
		System.out.println("3.修改分数");
		System.out.println("4.查看所有分数");
		System.out.println("5.退出系统");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1: {
			add();
			break;
		}
		case 2: {
			del();
			break;
		}
		case 3: {
			mod();
			break;
		}
		case 4: {
			view();
			break;
		}
		case 5: {
			System.exit(0);
			break;
		}
		default: {
			System.err.println("Error!");
			result();
			break;
		}
		}
	}

	public static void add() {
		System.out.println("请输入学生姓名：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("请输入学生成绩：");
		String score = sc.next();
		map.put(name, score);
		result();
	}

	public static void del() {
		System.out.println("请输入要删除学生的姓名：");
		Scanner sc = new Scanner(System.in);
		String pd = sc.next();
		String name = null;
		String score = null;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			name = it.next(); // 获取key
			score = map.get(name); // 获取value
			if (pd.equals(name)) {
				System.out.println("您要删除的学生信息为:" + name + ":" + score);
				System.out.println("确认删除请按1，取消并返回请按2");
				int pd2 = sc.nextInt();
				if (pd2 == 1) {
					map.remove(name);
					result();
				} else if (pd2 == 2) {
					menu();
				} else {
					System.err.println("Error");
					result();
				}
			}
		}
	}

	public static void mod() {
		System.out.println("请输入要修改学生的姓名：");
		Scanner sc = new Scanner(System.in);
		String pd = sc.next();
		String name = null;
		String score = null;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			name = it.next(); // 获取key
			score = map.get(name); // 获取value
			if (pd.equals(name)) {
				System.out.println("您要修改的学生信息为:" + name + ":" + score);
				System.out.println("请输入您要修改的成绩：");
				String rescore = sc.next();
				System.out.println("确认修改请按1，取消并返回请按2");
				int pd2 = sc.nextInt();
				if (pd2 == 1) {
					map.put(name, rescore);
					result();
				} else if (pd2 == 2) {
					menu();
				} else {
					System.err.println("Error");
					result();
				}
			}
		}
	}

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	public static void view() {
		System.out.println("学生信息如下：");
		// 将map.entrySet()转换成list
		ArrayList<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				// 升序排序
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		String name = null;
		String score = null;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			name = it.next(); // 获取key
			score = map.get(name); // 获取value
			System.out.println(name + ":" + score);
		}
		result();

	}

	public static void result() {
		System.out.println("操作成功！请选择：");
		System.out.println("1.返回。2.退出。");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		if (choose == 1) {
			menu();
		} else if (choose == 2) {
			System.exit(0);
		} else {
			System.err.println("Error");
			result();
		}
	}

}
