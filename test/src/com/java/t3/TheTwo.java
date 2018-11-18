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
		System.out.println("�����Խ������²���:");
		System.out.println("1.���student");
		System.out.println("2.�Ƴ�student");
		System.out.println("3.�޸ķ���");
		System.out.println("4.�鿴���з���");
		System.out.println("5.�˳�ϵͳ");
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
		System.out.println("������ѧ��first name��");
		String name1 = sc.next();
		System.out.println("������ѧ��last name��");
		String name2 = sc.next();
		System.out.println("������ѧ��ID��");
		int id = sc.nextInt();

		System.out.println("������ѧ���ɼ���");
		String score = sc.next();
		gradeMap.put(new Student(name1, name2, id), score);

		System.out.println(gradeMap.size());
		result();
	}

	public static void del() {
		System.out.println("������Ҫɾ��ѧ����ID��");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		String score = null;
		Iterator<Student> it = gradeMap.keySet().iterator();
		while (it.hasNext()) {
			Student s = it.next(); // ��ȡkey
			int id = s.getID(); // ��ȡid
			score = gradeMap.get(s); // ��ȡvalue
			if (pd == id) {
				System.out.println("��Ҫɾ����ѧ����ϢΪ:" + s + ":" + score);
				System.out.println("ȷ��ɾ���밴1��ȡ���������밴2");
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
				System.out.println("���޴���");
				result();
			}
		}
	}

	public static void mod() {
		System.out.println("������Ҫ�޸�ѧ����id��");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		String name = null;
		String score = null;
		Iterator<Student> it = gradeMap.keySet().iterator();
		while (it.hasNext()) {
			Student s = it.next(); // ��ȡkey
			int id = s.getID(); // ��ȡid
			score = gradeMap.get(s); // ��ȡvalue
			if (pd == id) {
				System.out.println("��Ҫ�޸ĵ�ѧ����ϢΪ:" + s + ":" + score);
				System.out.println("��ѡ����Ҫ�޸ĵĲ��֣�");
				System.out.println("1.firstname.2.lastname.3.id.4.����");
				int choose = sc.nextInt();
				switch (choose) {
				case 1: {
					System.out.println("��������Ҫ�޸ĵ���Ϣ:");
					String info = sc.next();
					s.setFirstname(info);
					gradeMap.put(s, score);
					result();
					break;
				}
				case 2: {
					System.out.println("��������Ҫ�޸ĵ���Ϣ:");
					String info = sc.next();
					s.setLastname(info);
					gradeMap.put(s, score);
					result();
					break;
				}
				case 3: {
					System.out.println("��������Ҫ�޸ĵ���Ϣ:");
					int info = sc.nextInt();
					s.setID(info);
					gradeMap.put(s, score);
					result();
					break;
				}
				case 4: {
					System.out.println("��������Ҫ�޸ĵ���Ϣ:");
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
				System.out.println("���޴���");
				result();
			}
		}
	}

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	public static void view() {
		System.out.println("ѧ����Ϣ���£�");
		System.out.println(gradeMap.size());
		// ��map.entrySet()ת����list
		ArrayList<Map.Entry<Student, String>> list = new ArrayList<Map.Entry<Student, String>>(gradeMap.entrySet());
		// ͨ���Ƚ�����ʵ������
		Collections.sort(list, new Comparator<Map.Entry<Student, String>>() {
			@Override
			public int compare(Map.Entry<Student, String> o1, Map.Entry<Student, String> o2) {
				// ��������
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
			Student s = it.next(); // ��ȡkey
			int id = s.getID();
			score = gradeMap.get(s); // ��ȡvalue
			System.out.println(s + ":" + score);
		}
		result();

	}

	public static void result() {
		System.out.println("�����ɹ�����ѡ��");
		System.out.println("1.���ء�2.�˳���");
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
