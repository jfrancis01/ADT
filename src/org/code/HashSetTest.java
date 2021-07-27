package org.code;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetTest {
	
	public static void main(String argv[]) {
		HashSet<ArrayList<String>> mySet = new HashSet<ArrayList<String>>();
		
		ArrayList<String> arrList1 = new ArrayList<>();
		arrList1.add("x");
		arrList1.add("y");
		arrList1.add("z");
		
		ArrayList<String> arrList2 = new ArrayList<>();
		arrList1.add("z");
		arrList1.add("y");
		arrList1.add("x");
		
		mySet.add(arrList1);
		mySet.add(arrList2);
		
		System.out.println(mySet.size());
		
	}

}
