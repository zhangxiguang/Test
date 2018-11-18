package com.oracle.t9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataInPutStreamDemo {

	public static void main(String[] args) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("src/1.txt"));
			DataOutputStream out = new DataOutputStream(new FileOutputStream("src/2.txt",true));
			int length;
			byte[] bs=new byte[1024*1024];
			while((length=in.read(bs))!=-1) {
				out.write(bs,0,length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
