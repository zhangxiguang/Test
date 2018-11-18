package com.oracle.t9;

public class SearchSoftware {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();// ��ȡ��ʼʱ��
		SearchSoftware s = new SearchSoftware();
		Search s1 = new Search(s);
		Search s2 = new Search(s);
		Search s3 = new Search(s);
		Search s4 = new Search(s);
		

		s1.start();
		s2.start();
		s3.start();
		s4.start();
		

		try {
			s1.join();
			s2.join();
			s3.join();
			s4.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();// ��ȡ����ʱ��
		System.err.println("����" + Search.getNumbers() + "���ļ�,����ʱ" + (endTime - startTime) / 1000 + "s");
	}

}
