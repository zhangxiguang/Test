package com.oracle.g1;

public class BandBooster {
	String name;  //����
	int boxesSold; //�۳����ֶ��ǹ��е�����
	public BandBooster(String newName){
		name=newName;
		boxesSold=0;
	}
	public String getName(){
		return name;
	}
	public int updateSales(int count){  
		return boxesSold;
	}
	public String toString(){
		return name+":"+boxesSold+"boxes";
	}
}
