package com.oracle.t10;

import java.net.ServerSocket;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8888);
			server.accept();
			System.out.println(server.getInetAddress().getHostAddress()+"������");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
