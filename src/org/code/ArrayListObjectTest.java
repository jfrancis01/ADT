package org.code;

import java.util.ArrayList;

public class ArrayListObjectTest {

	public static void main(String[] args) {
		ArrayList<int[]> vals = new ArrayList<int[]>();
		int[] val1 =  {1, 2};
		int[] val2 = {1,2};
		vals.add(val1);
		System.out.println(vals.contains(val2));

	}

}
