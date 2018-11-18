package com.oracle.t6;

public class Student implements Comparable{
	private String name;
	private int number;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Student(String name, int number, String sex) {
		super();
		this.name = name;
		this.number = number;
		this.sex = sex;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", sex=" + sex + "]";
	}
	@Override
	public int compareTo(Object o) {
		Student s=(Student) o;
		return this.number-s.getNumber();
	}
	

}
