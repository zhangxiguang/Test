package com.java.t3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunwaySimulator {
	private static int num = 1;// �����ܵ�
	private static ArrayList flylist = new ArrayList<>(); // ���ϵķɻ�
	private static ArrayList landlist = new ArrayList<>();// ���ϵķɻ�
	private static int flylv=0;  //������ȼ�
	private static int landlv=1; //�������ȼ�

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
			System.out.println("����������ָ�");
			String order = sc.next();
			if (order.equals("takeoff")) {
				if (num == 1) { // �ܵ�����
					System.out.println("��ǰ�ܵ����У��������");
					System.out.println("�����뺽���:");
					int landnum = sc.nextInt();
					System.out.println("��������һ��ָ�");
					String order2 = sc.next();
					if (order2.equals("next")) {
						for (int i = 0; i < landlist.size(); i++) {
							if (landnum == (int) landlist.get(i)) {
								num--;
								System.out.println("�����:" + (int) landlist.get(i) + "�Ѿ����");
								landlist.remove(landnum);
								num++;
							}
						}
					}
				} else {
					System.out.println("��ǰ�ܵ���æ������ִ�в�����");
					menu();
				}
			} else if (order.equals("land")) {
				if (num == 1) { // �ܵ�����
					System.out.println("��ǰ�ܵ����У����Խ���");
					System.out.println("�����뺽���:");
					int landnum = sc.nextInt();
					System.out.println("��������һ��ָ�");
					String order2 = sc.next();
					if (order2.equals("next")) {
						for (int i = 0; i < flylist.size(); i++) {
							if (landnum == (int) landlist.get(i)) {
								num--;
								System.out.println("�����:" + (int) flylist.get(i) + "�Ѿ����");
								flylist.remove(landnum);
								num++;
							}
						}
					}
				} else {
					System.out.println("��ǰ�ܵ���æ������ִ�в�����");
					menu();
				}
			}
		}
	}
}
