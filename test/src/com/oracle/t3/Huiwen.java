package com.oracle.t3;

import com.oraclesdp.common.SystemIn;

public class Huiwen {

	public static void main(String[] args) {
		System.out.println("请输入一个数字：");
		int num=SystemIn.nextInt();
		String num2;
		num2=String.valueOf(num);
		int I=num2.length();
		
		//偶数判断是否是回文数
		if(I%2==0){
			int i=I/2;
			String s1=num2.substring(0,i);
			String s2=num2.substring(i,I);
			StringBuffer s3=new StringBuffer(s2).reverse();//取倒序
			String s4=s3.toString();//转化为String
			if(s1.equals(s4)){
				System.out.println("恭喜，您输入的数字是回文数！");
			}
			else{
				System.out.println("很遗憾，您输入的数字不是回文数！");
			}
			
		}
		//奇数判断是否是回文数
		else{
			int L=I+1;
			int i=L/2;
			String s1=num2.substring(0,i-1);
			String s2=num2.substring(i,I);
			StringBuffer s3=new StringBuffer(s2).reverse();
			String s4=s3.toString();
			if(s1.equals(s4)){
				System.out.println("恭喜，您输入的数字是回文数！");
			}
			else{
				System.out.println("很遗憾，您输入的数字不是回文数！");
			}
		}
		
		
		
	}

}
