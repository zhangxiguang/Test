package com.oracle.t6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArraylistDemo {
	public static void main(String[] args) {
		Student s1=new Student("��ϣ��",2016117359,"��");
		Student s2=new Student("����",2016117342,"��");
		Student s3=new Student("����Դ",2016117314,"��");
		
		List list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		System.out.println(list.size());
		list.remove(1);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list.add(1, s2);
		
		
		Collections.sort(list);

		Iterator it=list.iterator();
		while(it.hasNext()) {
			Student s=(Student)it.next();
			System.out.println(s.getName());
		}
		
			
		
	}
}
