package com.oracle.t10;

import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		try {
			Socket client=new Socket("localhost", 8888);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
