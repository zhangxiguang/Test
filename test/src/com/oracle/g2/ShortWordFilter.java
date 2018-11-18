package com.oracle.g2;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortWordFilter implements Filter {
	public static void main(String[] args) {
		Filter swf = new ShortWordFilter();
		ArrayList list=new ArrayList();
		System.out.println("请随意输入一段字符串:(将检测里面长度小于5的单词)");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] ss=input.split(" ");
		for(String sss:ss) {
			list.add(sss);
		}
		list=collectAll(list, swf);
	}

	public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f) {
		ArrayList list2=new ArrayList();
		for(Object sss:objects) {
			if(f.accept(sss)) {
				list2.add(sss);
				System.out.println((String)sss);
			}
		}
		return list2;
	}

	@Override
	public boolean accept(Object x) {
		String ss = (String) x;
		if (ss.length() < 5) {
			return true;
		} else {
			return false;
		}

	}
}
