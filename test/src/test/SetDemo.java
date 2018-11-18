package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetDemo {
	// 定义一个Hashset数组
	static HashSet<Student> listtwo = new HashSet<>();

	public static void main(String[] args) {
		Student s1 = new Student(2016117309, "张希光", "男", 18);
		Student s2 = new Student(2016117314, "骆林源", "男", 19);
		Student s3 = new Student(2016117342, "刘洋", "男", 22);
		Student s4 = new Student(2016117338, "孙卫东", "男", 20);
		Student s5 = new Student(2016117322, "殷哲恒", "男", 21);
		Student s6 = new Student(2016117301, "何孟奇", "男", 45);

		// 将对象存入数组
		listtwo.add(s1);
		listtwo.add(s2);
		listtwo.add(s3);
		listtwo.add(s4);
		listtwo.add(s5);
		listtwo.add(s6);

		menu();
	}

	public static void menu() {
		System.out.println("欢迎使用学生管理系统");
		System.out.println("---1.添加信息----");
		System.out.println("---2.修改信息----");
		System.out.println("---3.删除信息----");
		System.out.println("---4.查看信息----");
		System.out.println("---5.退出系统----");
		System.out.println("------by  张希光");
		System.out.println("请输入您要选择的功能");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch (input) {
		case 1: {
			add();
			break;
		}
		case 2: {
			mod();
			break;
		}
		case 3: {
			del();
			break;
		}
		case 4: {
			show();
			break;
		}
		case 5: {
			System.exit(0);
			;
			break;
		}
		default: {
			System.err.println("Error Input");
		}
		}
	}

	public static void add() { // 添加信息
		System.out.println("请输入以下信息：");
		System.out.println("学号:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("姓名:");
		String name = sc.next();
		System.out.println("性别:");
		String sex = sc.next();
		System.out.println("年龄:");
		int age = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (number == it.next().getNumber()) {
				System.err.println("该学生信息已存在,重新输入请按1，返回请按2");
				int number2 = sc.nextInt();
				if (number2 == 1) {
					add();
				} else if (number2 == 2) {
					menu();
				} else {
					System.err.println("Error Input");
				}
			} else {
				listtwo.add(new Student(number, name, sex, age));
				System.out.println("恭喜！输入成功，如果要返回请按1，继续输入2");
				int input = sc.nextInt();
				if (input == 1) {
					menu();
				} else if (input == 2) {
					add();
				} else {
					System.err.println("Error input");
				}
			}
		}
	}

	public static void del() { // 删除
		System.out.println("请输入您要删除的学生学号：");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (it.next().getNumber() == number) {
				System.out.println("您要删除的学生信息为：" + it.next());
				System.out.println("确认删除请按1，取消删除并返回请按2");
				int number2 = sc.nextInt();
				if (number2 == 1) {
					listtwo.remove(it.next());
					System.out.println("信息已删除，继续删除请按y，返回请按n");
					String pd = sc.next();
					if (pd.equals("y")) {
						del();
					} else if (pd.equals("n")) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 2) {
					menu();
				} else {
					System.err.println("Error Input");
				}
			}
		}
	}

	public static void mod() { // 修改
		System.out.println("请输入您要修改的学生学号：");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (it.next().getNumber() == number) {
				System.out.println("您要修改的学生信息为：" + it.next());
				System.out.println("请选择要修改的部分：1.学号，2.姓名，3.性别，4.年龄");
				int number2 = sc.nextInt();
				if (number2 == 1) {
					System.out.println("请输入您要修改的内容:");
					int number3 = sc.nextInt();
					it.next().setNumber(number3);
					System.out.println("修改成功，继续修改请按1，返回上一层请按2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 2) {
					System.out.println("请输入您要修改的内容:");
					String number3 = sc.next();
					it.next().setName(number3);
					System.out.println("修改成功，继续修改请按1，返回上一层请按2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 3) {
					System.out.println("请输入您要修改的内容:");
					String number3 = sc.next();
					it.next().setSex(number3);
					System.out.println("修改成功，继续修改请按1，返回上一层请按2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 4) {
					System.out.println("请输入您要修改的内容:");
					int number3 = sc.nextInt();
					it.next().setAge(number3);
					System.out.println("修改成功，继续修改请按1，返回上一层请按2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else {
					System.err.println("Error Input");
				}
			}
		}
	}

	public static void show() { // 查看
		System.out.println("请输入您要查看的方式：");
		System.out.println("1.单一查看，2.浏览全部");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if (number == 1) {
			showone();
		} else if (number == 2) {
			showall();
		} else {
			System.err.println("Error Input");
		}
	}

	public static void showone() {// 查看一个
		System.out.println("请输入您要查看的学生学号：");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (it.next().getNumber() == number) {
				System.out.println("您要查看的学生信息为：" + it.next());
				System.out.println("继续查看请按1，返回请按2");
				int number2 = sc.nextInt();
				if (number2 == 1) {
					showone();
				} else if (number2 == 2) {
					menu();
				} else {
					System.err.println("Error Input");
				}
			}
		}
	}

	public static void showall() { // 查看所有
		Iterator<Student> it = listtwo.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("共计" + listtwo.size() + "条信息已经全部输出。");
		System.out.println("查看单一信息请按1，返回请按2");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if (number == 1) {
			showone();
		} else if (number == 2) {
			menu();
		} else {
			System.err.println("Error Input");
		}
	}

}
