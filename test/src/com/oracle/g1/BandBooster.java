package com.oracle.g1;

public class BandBooster {
	String name;  //姓名
	int boxesSold; //售出胡乐队糖果盒的数量
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
