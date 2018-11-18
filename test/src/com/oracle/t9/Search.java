package com.oracle.t9;

import java.io.File;
import java.util.Vector;

public class Search extends Thread {
	SearchSoftware s;

	static Vector<String> nameinfo = new Vector<>();
	static Vector<String> dirinfo = new Vector<>();
	static File[] roots = File.listRoots(); // 获取磁盘分区
	static String[] rootpath = new String[roots.length];
	private static int numbers = 0;
	

	public static int getNumbers() {
		return numbers;
	}

	
	public Search(SearchSoftware s) {
		super();
		this.s = s;
	}

	@Override
	public synchronized void run() {
//		for (int i = 0; i < roots.length; i++) {
//			String rootpath2 = roots[i].getPath();
//			rootpath[i]=rootpath2;
//			Search(rootpath2);
//		}
		String path="E:\\Web";
		Search(path);
	}

	public static void Search(String path) {
		File f = new File(path);
		for (int j = 0; j < roots.length; j++) {
			String[] childpath = f.list();
			for (int k = 0; k < childpath.length; k++) {
				File childf = new File(f, childpath[k]);
				if (childf.isDirectory()) {
					nameinfo.add(childf.getName());
					dirinfo.add(childf.getAbsolutePath());
					Search(childf.getAbsolutePath());
					numbers++;
					System.out.println("已经检索到"+numbers+"个文件");
				} else {
					nameinfo.add(childf.getName());
					dirinfo.add(childf.getAbsolutePath());
					numbers++;
					System.out.println("已经检索到"+numbers+"个文件");
				}
			}
		}
	}
}
