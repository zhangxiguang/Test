package com.oracle.g1;

import java.util.Random;
import java.util.Scanner;

public class Student {
	String Name;
	String Address;
	String Major;
	Double GPA;//Grade point average
	static Student student=new Student();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		System.out.println("请输入学生姓名：");
		student.Name=input;
		System.out.println("请输入学生地址：");
		input=sc.nextLine();
		student.Address=input;
		System.out.println("请输入学生专业：");
		input=sc.nextLine();
		student.Major=input;
		System.out.println("请选择要调用的方法：A or B");
		input=sc.nextLine();
		if(input.equals("A")){
			A(student.Name,student.Address,student.Major);
		}else if(input.equals("B")){
			B(student.Name,student.Address);
		}else{
			System.err.println("Error !");
		}
	}
	public static void computerGPA(){
		Random rm=new Random();
		double number=rm.nextDouble()*3.5+0.5;
		System.out.println(number);
	}
	public String toString(){
		return Name+Address+Major;
	}
	public static void A(String Name,String Address,String major){
		System.out.println(student.toString());
		System.out.print("GPA为：");
		computerGPA();
	}
	public static void B(String Name,String Address){
		student.Major="undeclared";
		System.out.println(student.toString());
		System.out.print("GPA为：");
		computerGPA();
	}

}

