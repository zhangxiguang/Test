package com.oracle.t6;

public class Product {
	private int number; // ���
	private String name; // ����
	private double price; // ����
	private int amount; // ����
	private double allprice;// ������Ʒ�ܼ�

	public Product(int number, String name, double price, int amount) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.allprice = 0;
	}

	public Product() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount += amount;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double price, int amount) {
		this.allprice = price * amount;
	}

	@Override
	public String toString() {
		return "��Ʒ��Ϣ [��Ʒ���=" + number + ", ��Ʒ����=" + name + ", ��Ʒ����=" + price + ", ��Ʒ����=" + amount + ", �۸�С��=" + allprice
				+ "]";
	}

}
