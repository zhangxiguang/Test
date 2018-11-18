package com.java.t3;

import java.util.Comparator;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TheTwo implements Comparator<String> {

	static TreeMap<Student, String> gradeMap = new TreeMap<>();
	static TreeMap<Integer, Student> idToStudentMap = new TreeMap<>();

	public static void main(String[] args) {
		Student s1 = new Student("a", "a", 1);
		Student s2 = new Student("b", "a", 2);
		Student s3 = new Student("b", "a", 1);
		Student s4 = new Student("a", "b", 2);
		Student s5 = new Student("a", "b", 1);

		gradeMap.put(s1, "80");
		gradeMap.put(s2, "82");
		gradeMap.put(s3, "78");
		gradeMap.put(s4, "50");
		gradeMap.put(s5, "90");
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
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生first name：");
		String name1 = sc.next();
		System.out.println("请输入学生last name：");
		String name2 = sc.next();
		System.out.println("请输入学生ID：");
		int id = sc.nextInt();

		System.out.println("请输入学生成绩：");
		String score = sc.next();
		gradeMap.put(new Student(name1, name2, id), score);

		System.out.println(gradeMap.size());
		result();
	}

	public static void del() {
		System.out.println("请输入要删除学生的ID：");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		String score = null;
		Iterator<Student> it = gradeMap.keySet().iterator();
		while (it.hasNext()) {
			Student s = it.next(); // 获取key
			int id = s.getID(); // 获取id
			score = gradeMap.get(s); // 获取value
			if (pd == id) {
				System.out.println("您要删除的学生信息为:" + s + ":" + score);
				System.out.println("确认删除请按1，取消并返回请按2");
				int pd2 = sc.nextInt();
				if (pd2 == 1) {
					gradeMap.remove(s);
					result();
				} else if (pd2 == 2) {
					menu();
				} else {
					System.err.println("Error");
					result();
				}
			} else {
				System.out.println("查无此人");
				result();
			}
		}
	}

	public static void mod() {
		System.out.println("请输入要修改学生的id：");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		String name = null;
		String score = null;
		Iterator<Student> it = gradeMap.keySet().iterator();
		while (it.hasNext()) {
			Student s = it.next(); // 获取key
			int id = s.getID(); // 获取id
			score = gradeMap.get(s); // 获取value
			if (pd == id) {
				System.out.println("您要修改的学生信息为:" + s + ":" + score);
				System.out.println("请选择您要修改的部分：");
				System.out.println("1.firstname.2.lastname.3.id.4.分数");
				int choose = sc.nextInt();
				switch (choose) {
				case 1: {
					System.out.println("请输入您要修改的信息:");
					String info = sc.next();
					s.setFirstname(info);
					gradeMap.put(s, score);
					result();
					break;
				}
				case 2: {
					System.out.println("请输入您要修改的信息:");
					String info = sc.next();
					s.setLastname(info);
					gradeMap.put(s, score);
					result();
					break;
				}
				case 3: {
					System.out.println("请输入您要修改的信息:");
					int info = sc.nextInt();
					s.setID(info);
					gradeMap.put(s, score);
					result();
					break;
				}
				case 4: {
					System.out.println("请输入您要修改的信息:");
					String info = sc.next();
					gradeMap.put(s, info);
					result();
					break;
				}
				default: {
					System.err.println("Error");
					result();
				}
				}
			} else {
				System.out.println("查无此人");
				result();
			}
		}
	}

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	public static void view() {
		System.out.println("学生信息如下：");
		System.out.println(gradeMap.size());
		// 将map.entrySet()转换成list
		ArrayList<Map.Entry<Student, String>> list = new ArrayList<Map.Entry<Student, String>>(gradeMap.entrySet());
		// 通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<Student, String>>() {
			@Override
			public int compare(Map.Entry<Student, String> o1, Map.Entry<Student, String> o2) {
				// 升序排序
				if ((o1.getKey().getLastname().compareTo(o2.getKey().getLastname())) > 0) {
					return 1;
				} else if ((o1.getKey().getLastname().compareTo(o2.getKey().getLastname())) < 0) {
					return -1;
				} else {
					if ((o1.getKey().getFirstname().compareTo(o2.getKey().getFirstname())) > 0) {
						return 1;
					} else if ((o1.getKey().getFirstname().compareTo(o2.getKey().getFirstname())) < 0) {
						return -1;
					} else {
						if (((int)o1.getKey().getID() - (int)o2.getKey().getID())>0) {
							System.out.println("test");
							return 1;
						} else if (((int)o1.getKey().getID() - (int)o2.getKey().getID()) < 0) {
							System.out.println("??????");
							return -1;
						} else {
							System.out.println("1231231231231");
							return 0;
						}
					}
				}
			}
		});
		String score;
		Iterator<Student> it = gradeMap.keySet().iterator();
		while (it.hasNext()) {
			Student s = it.next(); // 获取key
			int id = s.getID();
			score = gradeMap.get(s); // 获取value
			System.out.println(s + ":" + score);
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
