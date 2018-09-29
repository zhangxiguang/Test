package com.oracle.t4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class jiangxu {
	public static void main(String[] args) {
		int[] a = new int[30];
		for (int i = 0; i < a.length; i++) {
			Scanner sc = new Scanner(System.in);
			
			int count=0;
			while(count<30){
				int num=(int)(Math.random()*100);
				boolean flag=true;
				for(int j = 0; j < 30; j++){
					if(num==a[j]){
						flag=false;
						break;
					}
				}
				if(flag==true){
					a[count]=num;
					count++;
				}
			}
		}
		Arrays.sort(a);
		for (int k = 1; k <= a.length; k++){
			System.out.print(a[a.length-k]+" ");
		}
	}
}
