package com.java.t3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class DistanceTo implements Comparable<DistanceTo> {
	private String target;// city
	private int distance;

	public DistanceTo(String city, int dist) {
		target = city;
		distance = dist;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(DistanceTo arg0) {
		return distance - arg0.distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistanceTo other = (DistanceTo) obj;
		if (distance != other.distance)
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	private static TreeSet<DistanceTo> Pendleton = new TreeSet<>();
	private static TreeSet<DistanceTo> Pierre = new TreeSet<>();
	private static TreeSet<DistanceTo> Pueblo = new TreeSet<>();
	private static TreeSet<DistanceTo> Phoenix = new TreeSet<>();
	private static TreeSet<DistanceTo> Peoria = new TreeSet<>();
	private static TreeSet<DistanceTo> Pittsburgh = new TreeSet<>();
	private static TreeSet<DistanceTo> Pensacola = new TreeSet<>();
	private static TreeSet<DistanceTo> Princeton = new TreeSet<>();
	private static Map<String, Integer> map = new HashMap<>();
	private static TreeSet<DistanceTo> shortestKnownDistance = new TreeSet<>();

	// private static String[] fromland= {"Pedleton","Pierre","Pueblo",
//			"Phoenix","Peoria","Pittsburgh","Pensacola","Princeton"};
	private static String from = "Pedleton";// Æðµã
	private static int min=1000;

	public static void main(String[] args) {
		// Pedleton
		DistanceTo s1 = new DistanceTo("Pierre", 2);
		DistanceTo s2 = new DistanceTo("Pueblo", 8);
		DistanceTo s3 = new DistanceTo("Phoenix", 4);
		Pendleton.add(s1);
		Pendleton.add(s2);
		Pendleton.add(s3);
		// Pierre
		DistanceTo s4 = new DistanceTo("Pendleton", 2);
		DistanceTo s5 = new DistanceTo("Pueblo", 3);
		Pierre.add(s4);
		Pierre.add(s5);
		// Pueblo
		DistanceTo s6 = new DistanceTo("Pendleton", 8);
		DistanceTo s7 = new DistanceTo("Pierre", 3);
		DistanceTo s8 = new DistanceTo("Phoenix", 3);
		DistanceTo s9 = new DistanceTo("Peoria", 3);
		Pueblo.add(s6);
		Pueblo.add(s7);
		Pueblo.add(s8);
		Pueblo.add(s9);
		// Phoenix
		DistanceTo s10 = new DistanceTo("Pendleton", 4);
		DistanceTo s11 = new DistanceTo("Pueblo", 3);
		DistanceTo s12 = new DistanceTo("Peoria", 4);
		DistanceTo s13 = new DistanceTo("Pittsburgh", 10);
		DistanceTo s14 = new DistanceTo("Pensacola", 5);
		Phoenix.add(s10);
		Phoenix.add(s11);
		Phoenix.add(s12);
		Phoenix.add(s13);
		Phoenix.add(s14);
		// Peoria
		DistanceTo s15 = new DistanceTo("Pueblo", 3);
		DistanceTo s16 = new DistanceTo("Phoenix", 4);
		DistanceTo s17 = new DistanceTo("Pittsburgh", 5);
		Peoria.add(s15);
		Peoria.add(s16);
		Peoria.add(s17);
		// Pittsburgh
		DistanceTo s18 = new DistanceTo("Peoria", 5);
		DistanceTo s19 = new DistanceTo("Phoenix", 10);
		DistanceTo s20 = new DistanceTo("Pensacola", 4);
		DistanceTo s21 = new DistanceTo("Princeton", 2);
		Pittsburgh.add(s18);
		Pittsburgh.add(s19);
		Pittsburgh.add(s20);
		Pittsburgh.add(s21);
		// Pensacola
		DistanceTo s22 = new DistanceTo("Phoenix", 5);
		DistanceTo s23 = new DistanceTo("Pittsburgh", 4);
		DistanceTo s24 = new DistanceTo("Princeton", 5);
		Pensacola.add(s22);
		Pensacola.add(s23);
		Pensacola.add(s24);
		// Princeton
		DistanceTo s25 = new DistanceTo("Pittsburgh", 2);
		DistanceTo s26 = new DistanceTo("Pensacola", 5);
		Princeton.add(s25);
		Princeton.add(s26);
		
//		map.add(Pendleton);
//		map.add(Pierre);
//		map.add(Pueblo);
//		map.add(Phoenix);
//		map.add(Peoria);
//		map.add(Pittsburgh);
//		map.add(Pensacola);
//		map.add(Princeton);
		
		search(Pendleton);
		
		Iterator<DistanceTo> it=Pendleton.iterator();
		while(it.hasNext()){
			DistanceTo s=it.next();
			int num=s.getDistance();
			String name=s.getTarget();
			if(num<min) {
				min=num;
				map.put(name,min);
//				System.out.println(map);
			}
		}
		
		
		
//		Iterator it2=map.entrySet().iterator();
//		while(it2.hasNext()) {
//			System.out.println(it2.next());
//		}
		
		
	}
	public static void search(TreeSet<DistanceTo> o) {
		while(!o.equals("Princeton")) {
			Iterator<DistanceTo> it=o.iterator();
			while(it.hasNext()){
				DistanceTo s=it.next();
				int num=s.getDistance();
				String name=s.getTarget();
				if(num<min) {
					min=num;
					map.put(name,min);
				}
			}
			min=1000;
		}
	}
}
