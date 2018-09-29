package com.oracle.t3;

import com.oraclesdp.common.SystemIn;

public class LIngxing {
	public static void main(String[] args) {
		System.out.println("你要输出几行的菱形？");
		int N=SystemIn.nextInt();//定义一个N排的菱形
		int i=0;//循环次数
		int a=1;//当前行数
		int b=N-a;//每一行的空格数
		int l=2*a-1;//每一行的*的数量
		int M=b+l;//每一行总的字符数
		for (;;) {
				if(i<b){
					System.out.print(" ");
					i++;
				}
				if(i>=b&&i<M){
					System.out.print("*");
					i++;
				}
				if(i>=M&&a<N){
				System.out.println();
				a++;
				b=N-a;
				l=2*a-1;
				M=b+l;
				i=0;
				}
				if(a>=N){
					b=a-N;//打印下三角时，每一行的空格数
					l=4*N-2*a-1;  //打印下三角时，每一行的*的数量
				}
				if(a>=N&&i<b){
					System.out.print(" ");
					i++;
				}
				if(a>=N&&i>=b&&i<M){
					System.out.print("*");
					i++;
				}
				if(a>=N&&i>=M){
					System.out.println();
					a++;
					b=a-N;
					l=4*N-2*a-1;
					M=b+l;
					i=0;
				}
				if(a>(2*N-1)){
					break;
				}
			
		}
	}
}
