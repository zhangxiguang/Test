package com.oracle.g1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CreditCard {
	static double baseRate; // ��С/�������ʣ�interest rate��
	static int lastAccountNumber = 1234567;// ������ͻ�������˻����
	String accountholder;// ���ÿ�ӵ���ߵ�����.
	int accountNumber; // ��7λ���ֱ�ʾ��Ψһ�ı�ʶ��
	int creditScore; // ��������
	double rate; // ÿ����ȡ�����ÿ�����
	double balance; // ���ÿ����ѽ��(�Ѿ����ѵ�)
	double creditLimit; // ���ö�ȣ�credit limit��
	double money;// ����Ϊ�����������ÿ����ѽ��

	public CreditCard(String accountholder, int creditScore) {
		this.accountholder = accountholder;
		this.creditScore = creditScore;
		this.lastAccountNumber = lastAccountNumber;
		this.lastAccountNumber++;
		this.balance = 0;
		updatecreditScore(this.creditScore);
	}

	public void updatecreditScore(int creditScore) { // �������ʼ����
		if (creditScore > 0 && creditScore <= 300) {
			this.baseRate += 0.1;
			creditLimit = 1000;
		} else if (creditScore > 300 && creditScore <= 500) {
			this.baseRate += 0.07;
			creditLimit = 3000;
		} else if (creditScore > 500 && creditScore <= 700) {
			this.baseRate += 0.04;
			creditLimit = 7000;
		} else {
			this.baseRate += 0.01;
			creditLimit = 15000;
		}
	}

	public void malkePurchase(int amount) { // �������ÿ����ѽ�balance��
		if ((amount + balance) > creditLimit) {
			System.err.println("Error�����Ķ�Ȳ��㣡");
		} else {
			balance = creditLimit - amount;
			System.out.println("�������ѣ����Ѻ����Ķ��Ϊ��" + balance);
		}
	}

	public void makePayment(int amount) { // ���µ�ǰ���ÿ����ѽ��
		if (amount > balance) {
			balance = 0;
			System.out.println("��ϲ������Ƿ���Ѿ�ȫ�����塣");
		} else if (amount < (balance * 0.1)) {
			balance = balance - amount;
		}
		while (balance == 0) {
			creditScore += 10;
			updatecreditScore(creditScore);
		}
	}

	public void raiseRate() { // ͨ��һ�������İٷֱ��������˻������ߵ�����.
		System.out.println("��������Ҫ�������ӵİٷֱȣ�");
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		rate += input;
	}

	public void raiseLimit() { // ͨ��һ����������Ԫ�����������˻������ߵ����ö��.
		System.out.println("��������Ҫ�������ӵ����ö�ȣ�");
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		creditLimit += input;
	}

	public void calculateBalance() { // ����Ϊ�����������ÿ����ѽ��
		money = balance + (balance * (rate / 12));
		System.out.println("�����µ����ѽ��Ϊ��" + money);
	}

	public String toString(String accountholder, int accountNumber) {
		return "�˻���:" + accountholder + "�˻���:" + "****" + String.valueOf(accountNumber).substring(4) + "�������ѽ��Ϊ:"
				+ money + "���ö��Ϊ��" + creditLimit;
	}

	public void testPerson() { // ���û�����
		int year;
		int monthS; // ��ʼ��
		int day;
		int dayR;// ������
		int monthR;// ������
		int count = 0; // ���ӵ���
		String startday;
		String rightnow;
		String endday;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startday = df.format(new Date());
		System.out.println("���Կ�ʼʱ��Ϊ��" + startday);
		Calendar c = Calendar.getInstance();// ���Զ�ÿ��ʱ���򵥶��޸�
		year = c.get(Calendar.YEAR);
		monthS = c.get(Calendar.MONTH);
		day = c.get(Calendar.DATE);

		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		int maxDate = c.get(Calendar.DATE);// ��ǰ�µ��������

		while (count < 6) {
			rightnow = df.format(new Date());
			System.out.println("����ʱ��Ϊ��" + rightnow);
			monthR = c.get(Calendar.MONTH);
			dayR = c.get(Calendar.DATE);
			if (dayR == maxDate) {
				if ((monthR - monthS) == 1) {
					count++;
					monthS = monthR;
				}
				if (balance > 0) {
					System.out.println("��ǰ����Ϊ��" + balance + "����ѡ���Ƿ񻹿�ǣ�Y����N");
					Scanner sc = new Scanner(System.in);
					String input = sc.nextLine();
					if (input.equals("Y")) {
						System.out.println("��������Ҫ����Ľ�");
						int money = sc.nextInt();
						makePayment(money);
					} else if (input.equals("N")) {
						System.out.println("���������������2%������");
						rate += 0.02;
					} else {
						System.err.println("Error!");
					}
				}
				toString();
			}
		}

	}

	public static CreditCard register() { // ע���˻�
		System.out.println("����ע���˻�");
		System.out.println("�����������˻�����");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("�����������������ֹ���ֵ��");
		int input2 = sc.nextInt();
		CreditCard person = new CreditCard(input, input2);
		person.menu();
		return person;
	}

	public static void main(String[] args) {
		register();
	}

	public void menu() {
		System.out.println("��ӭʹ����ϣ���Ʒ�����ÿ�����ϵͳ");
		System.out.println("��ѡ���ܣ�");
		System.out.println("1.ͨ��һ�������İٷֱ��������˻������ߵ�����");
		System.out.println("2.ͨ��һ����������Ԫ�����������˻������ߵ����ö��");
		System.out.println("3.���û���������");
		Scanner sc = new Scanner(System.in);
		int chose = sc.nextInt();
		switch (chose) {
		case 1: {
			raiseRate();
			break;
		}

		case 2: {
			raiseLimit();
			break;
		}
		case 3: {
			testPerson();
			break;
		}
		default:
			System.err.println("�������");
			break;
		}
	}
}
