package com.oracle.t9;

import java.io.File;
import java.util.Scanner;

public class AllFileDemo {

	public static void main(String[] args) {
		System.out.println("请输入你想遍历的地址:");
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		showall(path, 0);
	}

	public static void showall(String path, int floor) {
		File f = new File(path);
		if (f.exists()) {
			String[] childpath = f.list();
			floor = floor + 3;
			for (int i = 0; i < childpath.length; i++) {
				File childf = new File(f, childpath[i]);
				if (childf.isDirectory()) {
					for (int n = 0; n < floor; n++) {
						System.out.print(" ");
					}
					System.out.println("Dir:" + childf.getName());
					showall(childf.getPath(), floor);
				} else if (childf.isFile()) {
					for (int n = 0; n < floor; n++) {
						System.out.print(" ");
					}
					System.out.println("File:" + childf.getName());
				}
			}
		} else {
			System.err.println("Error");
		}
	}

}
