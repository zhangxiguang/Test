package com.oracle.t9;

import java.io.File;
import java.io.IOException;

public class HomeWorkDemo {

	public static void main(String[] args) {
		String path = "E:\\大学作业";
		creat(path);
	}

	public static void creat(String path) {
		File f = new File(path);
		f.mkdir();
		int year = 2016;
		boolean flag = false;// 判断是否是闰年

		for (int i = 0; i < 4; i++) { // 创建年份文件夹
			String yearname = year + "年";
			File ff = new File(f.getPath(), yearname);
			ff.mkdir();
			if (year % 4 == 0 && year % 100 != 0) {
				flag = true;
			} else if (year % 100 == 0 && year % 400 == 0) {
				flag = true;
			} else {
				flag = false;
			}
			year++;
			int month = 1;
			for (int j = 0; j < 12; j++) {
				String monthname = month + "月"; // 创建月份文件夹
				File fff = new File(ff.getPath(), monthname);
				fff.mkdir();

				int day = 1;
				int daymax = 0; // 每个月份最大天数 下面是判断每个月最大天数
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					daymax = 31;
				} else if (month == 4 || month == 6 || month == 9 || month == 11) {
					daymax = 30;
				} else if (month == 2) {
					if (flag == true) {
						daymax = 29;
					} else {
						daymax = 28;
					}
				}
				month++;

				for (int k = 0; k < daymax; k++) {
					String dayname = day + "号";
					File ffff = new File(fff.getPath(), dayname);
					ffff.mkdir();
					String dayname2=yearname+monthname+dayname+".txt";
					File fffff=new File(ffff.getPath(),dayname2);
					try {
						fffff.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					day++;
				}

			}
		}
	}

}
