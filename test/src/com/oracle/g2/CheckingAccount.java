package com.oracle.g2;

public class CheckingAccount extends BankAccount {
	private int withdrawals;
	final int FREE_WITHDRAWALS = 3;
	final int WITHDRAWAL_FEE = 1;

	/**
	 * Constructs a checking account with a zero balance.
	 * 构造一个零余额的支票帐户。
	 */
	public CheckingAccount() {
		withdrawals = 0;
	}

	public void withdraw(double amount) {
		super.withdraw(amount);
		withdrawals++;
		workout();
	}

	public void monthEnd() {
		withdrawals = 0;
	}
	
	public void deposit(double amount) {
		super.deposit(amount);
		withdrawals++;
		workout();
	}
	
	public void workout() {
		if(withdrawals>FREE_WITHDRAWALS) {
			super.withdraw(1);
		}
	}
	
	public static void main(String[] args) {
		CheckingAccount test=new CheckingAccount();
		test.deposit(50);
		test.withdraw(10);
		test.withdraw(10);
		test.withdraw(10);
		System.out.println(test.getBalance());
	}
}
