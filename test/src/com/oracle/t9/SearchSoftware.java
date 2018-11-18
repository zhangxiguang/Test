package com.oracle.t9;

public class SearchSoftware {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();// 获取开始时间
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
		long endTime = System.currentTimeMillis();// 获取结束时间
		System.err.println("共计" + Search.getNumbers() + "个文件,共用时" + (endTime - startTime) / 1000 + "s");
	}

}
