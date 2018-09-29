package com.oracle.t3;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		int sum=1;
		int k= 0;
		int j=2;
		for(int i=1;i<=10000;i++){
			for(j=2;j<i;j++){
				k=i%j;	
				if(k==0){
					break;
				}
			}
			if(i==j){
				System.out.println(i);
				sum+=i;
			}
				
		}
		System.out.println("sum="+sum);
		}
		
		
	}

