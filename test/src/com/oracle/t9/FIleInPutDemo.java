package com.oracle.t9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FIleInPutDemo {

	public static void main(String[] args) {
		try {
			FileInputStream in=new FileInputStream("src/1.txt");
			int bytedase;
			FileOutputStream out=new FileOutputStream("src/2.txt");
			while((bytedase=in.read())!=-1) {
				out.write(bytedase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
