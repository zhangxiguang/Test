package com.oracle.g1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CreditCard {
	static double baseRate; // 最小/基本利率（interest rate）
	static int lastAccountNumber = 1234567;// 分配给客户的最后账户编号
	String accountholder;// 信用卡拥有者的姓名.
	int accountNumber; // 用7位数字表示的唯一的标识号
	int creditScore; // 信用评分
	double rate; // 每年收取的信用卡利率
	double balance; // 信用卡消费金额(已经消费的)
	double creditLimit; // 信用额度（credit limit）
	double money;// 以月为基础计算信用卡消费金额

	public CreditCard(String accountholder, int creditScore) {
		this.accountholder = accountholder;
		this.creditScore = creditScore;
		this.lastAccountNumber = lastAccountNumber;
		this.lastAccountNumber++;
		this.balance = 0;
		updatecreditScore(this.creditScore);
	}

	public void updatecreditScore(int creditScore) { // 更新利率及额度
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

	public void malkePurchase(int amount) { // 更新信用卡消费金额（balance）
		if ((amount + balance) > creditLimit) {
			System.err.println("Error，您的额度不足！");
		} else {
			balance = creditLimit - amount;
			System.out.println("可以消费，消费后您的额度为：" + balance);
		}
	}

	public void makePayment(int amount) { // 更新当前信用卡消费金额
		if (amount > balance) {
			balance = 0;
			System.out.println("恭喜！您的欠款已经全部还清。");
		} else if (amount < (balance * 0.1)) {
			balance = balance - amount;
		}
		while (balance == 0) {
			creditScore += 10;
			updatecreditScore(creditScore);
		}
	}

	public void raiseRate() { // 通过一个给定的百分比来增加账户持有者的利率.
		System.out.println("请输入您要给定增加的百分比：");
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		rate += input;
	}

	public void raiseLimit() { // 通过一个给定的美元数量来增加账户持有者的信用额度.
		System.out.println("请输入您要给定增加的信用额度：");
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		creditLimit += input;
	}

	public void calculateBalance() { // 以月为基础计算信用卡消费金额
		money = balance + (balance * (rate / 12));
		System.out.println("您本月的消费金额为：" + money);
	}

	public String toString(String accountholder, int accountNumber) {
		return "账户名:" + accountholder + "账户号:" + "****" + String.valueOf(accountNumber).substring(4) + "本月消费金额为:"
				+ money + "信用额度为：" + creditLimit;
	}

	public void testPerson() { // 新用户评估
		int year;
		int monthS; // 开始月
		int day;
		int dayR;// 现在天
		int monthR;// 现在月
		int count = 0; // 增加的月
		String startday;
		String rightnow;
		String endday;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startday = df.format(new Date());
		System.out.println("测试开始时间为：" + startday);
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		year = c.get(Calendar.YEAR);
		monthS = c.get(Calendar.MONTH);
		day = c.get(Calendar.DATE);

		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		int maxDate = c.get(Calendar.DATE);// 当前月的最大天数

		while (count < 6) {
			rightnow = df.format(new Date());
			System.out.println("现在时间为：" + rightnow);
			monthR = c.get(Calendar.MONTH);
			dayR = c.get(Calendar.DATE);
			if (dayR == maxDate) {
				if ((monthR - monthS) == 1) {
					count++;
					monthS = monthR;
				}
				if (balance > 0) {
					System.out.println("当前消费为：" + balance + "，请选择是否还款。是：Y，否：N");
					Scanner sc = new Scanner(System.in);
					String input = sc.nextLine();
					if (input.equals("Y")) {
						System.out.println("请输入您要还款的金额：");
						int money = sc.nextInt();
						makePayment(money);
					} else if (input.equals("N")) {
						System.out.println("您放弃还款，将增加2%的利率");
						rate += 0.02;
					} else {
						System.err.println("Error!");
					}
				}
				toString();
			}
		}

	}

	public static CreditCard register() { // 注册账户
		System.out.println("请先注册账户");
		System.out.println("请输入您的账户名：");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("请输入您的信用评分估计值：");
		int input2 = sc.nextInt();
		CreditCard person = new CreditCard(input, input2);
		person.menu();
		return person;
	}

	public static void main(String[] args) {
		register();
	}

	public void menu() {
		System.out.println("欢迎使用张希光出品的信用卡管理系统");
		System.out.println("请选择功能：");
		System.out.println("1.通过一个给定的百分比来增加账户持有者的利率");
		System.out.println("2.通过一个给定的美元数量来增加账户持有者的信用额度");
		System.out.println("3.新用户评估程序");
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
			System.err.println("输入错误");
			break;
		}
	}
}
