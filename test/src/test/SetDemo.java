package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetDemo {
	// ����һ��Hashset����
	static HashSet<Student> listtwo = new HashSet<>();

	public static void main(String[] args) {
		Student s1 = new Student(2016117309, "��ϣ��", "��", 18);
		Student s2 = new Student(2016117314, "����Դ", "��", 19);
		Student s3 = new Student(2016117342, "����", "��", 22);
		Student s4 = new Student(2016117338, "������", "��", 20);
		Student s5 = new Student(2016117322, "���ܺ�", "��", 21);
		Student s6 = new Student(2016117301, "������", "��", 45);

		// �������������
		listtwo.add(s1);
		listtwo.add(s2);
		listtwo.add(s3);
		listtwo.add(s4);
		listtwo.add(s5);
		listtwo.add(s6);

		menu();
	}

	public static void menu() {
		System.out.println("��ӭʹ��ѧ������ϵͳ");
		System.out.println("---1.�����Ϣ----");
		System.out.println("---2.�޸���Ϣ----");
		System.out.println("---3.ɾ����Ϣ----");
		System.out.println("---4.�鿴��Ϣ----");
		System.out.println("---5.�˳�ϵͳ----");
		System.out.println("------by  ��ϣ��");
		System.out.println("��������Ҫѡ��Ĺ���");
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

	public static void add() { // �����Ϣ
		System.out.println("������������Ϣ��");
		System.out.println("ѧ��:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("����:");
		String name = sc.next();
		System.out.println("�Ա�:");
		String sex = sc.next();
		System.out.println("����:");
		int age = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (number == it.next().getNumber()) {
				System.err.println("��ѧ����Ϣ�Ѵ���,���������밴1�������밴2");
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
				System.out.println("��ϲ������ɹ������Ҫ�����밴1����������2");
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

	public static void del() { // ɾ��
		System.out.println("��������Ҫɾ����ѧ��ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (it.next().getNumber() == number) {
				System.out.println("��Ҫɾ����ѧ����ϢΪ��" + it.next());
				System.out.println("ȷ��ɾ���밴1��ȡ��ɾ���������밴2");
				int number2 = sc.nextInt();
				if (number2 == 1) {
					listtwo.remove(it.next());
					System.out.println("��Ϣ��ɾ��������ɾ���밴y�������밴n");
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

	public static void mod() { // �޸�
		System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (it.next().getNumber() == number) {
				System.out.println("��Ҫ�޸ĵ�ѧ����ϢΪ��" + it.next());
				System.out.println("��ѡ��Ҫ�޸ĵĲ��֣�1.ѧ�ţ�2.������3.�Ա�4.����");
				int number2 = sc.nextInt();
				if (number2 == 1) {
					System.out.println("��������Ҫ�޸ĵ�����:");
					int number3 = sc.nextInt();
					it.next().setNumber(number3);
					System.out.println("�޸ĳɹ��������޸��밴1��������һ���밴2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 2) {
					System.out.println("��������Ҫ�޸ĵ�����:");
					String number3 = sc.next();
					it.next().setName(number3);
					System.out.println("�޸ĳɹ��������޸��밴1��������һ���밴2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 3) {
					System.out.println("��������Ҫ�޸ĵ�����:");
					String number3 = sc.next();
					it.next().setSex(number3);
					System.out.println("�޸ĳɹ��������޸��밴1��������һ���밴2");
					int number4 = sc.nextInt();
					if (number4 == 1) {
						mod();
					} else if (number4 == 2) {
						menu();
					} else {
						System.err.println("Error Input");
					}
				} else if (number2 == 4) {
					System.out.println("��������Ҫ�޸ĵ�����:");
					int number3 = sc.nextInt();
					it.next().setAge(number3);
					System.out.println("�޸ĳɹ��������޸��밴1��������һ���밴2");
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

	public static void show() { // �鿴
		System.out.println("��������Ҫ�鿴�ķ�ʽ��");
		System.out.println("1.��һ�鿴��2.���ȫ��");
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

	public static void showone() {// �鿴һ��
		System.out.println("��������Ҫ�鿴��ѧ��ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Iterator<Student> it=listtwo.iterator();
		while(it.hasNext()) {
			if (it.next().getNumber() == number) {
				System.out.println("��Ҫ�鿴��ѧ����ϢΪ��" + it.next());
				System.out.println("�����鿴�밴1�������밴2");
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

	public static void showall() { // �鿴����
		Iterator<Student> it = listtwo.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("����" + listtwo.size() + "����Ϣ�Ѿ�ȫ�������");
		System.out.println("�鿴��һ��Ϣ�밴1�������밴2");
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
