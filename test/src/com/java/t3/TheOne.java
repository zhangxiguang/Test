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
		System.out.println("������ѧ��������");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("������ѧ���ɼ���");
		String score = sc.next();
		map.put(name, score);
		result();
	}

	public static void del() {
		System.out.println("������Ҫɾ��ѧ����������");
		Scanner sc = new Scanner(System.in);
		String pd = sc.next();
		String name = null;
		String score = null;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			name = it.next(); // ��ȡkey
			score = map.get(name); // ��ȡvalue
			if (pd.equals(name)) {
				System.out.println("��Ҫɾ����ѧ����ϢΪ:" + name + ":" + score);
				System.out.println("ȷ��ɾ���밴1��ȡ���������밴2");
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
		System.out.println("������Ҫ�޸�ѧ����������");
		Scanner sc = new Scanner(System.in);
		String pd = sc.next();
		String name = null;
		String score = null;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			name = it.next(); // ��ȡkey
			score = map.get(name); // ��ȡvalue
			if (pd.equals(name)) {
				System.out.println("��Ҫ�޸ĵ�ѧ����ϢΪ:" + name + ":" + score);
				System.out.println("��������Ҫ�޸ĵĳɼ���");
				String rescore = sc.next();
				System.out.println("ȷ���޸��밴1��ȡ���������밴2");
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
		System.out.println("ѧ����Ϣ���£�");
		// ��map.entrySet()ת����list
		ArrayList<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// ͨ���Ƚ�����ʵ������
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				// ��������
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		String name = null;
		String score = null;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			name = it.next(); // ��ȡkey
			score = map.get(name); // ��ȡvalue
			System.out.println(name + ":" + score);
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
