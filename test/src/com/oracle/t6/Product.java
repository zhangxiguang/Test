package com.oracle.t6;

public class Product {
	private int number; // 编号
	private String name; // 名称
	private double price; // 单价
	private int amount; // 数量
	private double allprice;// 单个商品总价

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
		return "商品信息 [商品编号=" + number + ", 商品名称=" + name + ", 商品单价=" + price + ", 商品数量=" + amount + ", 价格小计=" + allprice
				+ "]";
	}

}
