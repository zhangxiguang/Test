package com.oracle.t4;

import java.util.Random;

public class zhiri {
	public static void main(String[] args) {
		int[] a = new int[30];
		// for(int i=0;i<30;i++){
		// a[i]=i+1;
		// }
		int count = 0;
		while (count < 30) {
			for (int j = 0; j < 30; j++) {
				int sone = (int) (Math.random() * 30);
				boolean flag = true;
				for (int i = 0; i < 30; i++) {
					if (sone == a[i]) {
						flag = false;
						break;
					}
				}
				if(flag == true){
					a[count]=sone;
					System.out.print(a[count]+" ");
					count++;
				}

			}
		}
	}
}
