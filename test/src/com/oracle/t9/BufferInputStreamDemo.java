package com.oracle.t9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferInputStreamDemo {

	public static void main(String[] args) {
		String path="F:\\刘洋没有张希光帅";
		String copypath="F:\\";
		allfile(path, copypath);
	}
	public static void allfile(String path,String copypath) {
		try {
			File ff=new File(path);
			String[] childpath=ff.list();
			for(int i=0;i<childpath.length;i++) {
				BufferedInputStream in=new BufferedInputStream(new FileInputStream(childpath[i]));
				BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(copypath));
				int length;
				byte[] bs=new byte[1024*1024];
				while((length=in.read(bs))!=-1) {
					out.write(bs,0,length);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
