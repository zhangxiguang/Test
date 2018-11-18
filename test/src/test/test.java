package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test {

	public static void main(String args[]) {
		String person1="z1";
		String person2=new String("z1");
		String person3="z1";
		
		Set set=new HashSet();
		set.add(person1);
		set.add(person2);
		set.add(person3);
		System.out.println(set.size());
		Iterator it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

