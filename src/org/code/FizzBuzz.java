package org.code;

public class FizzBuzz {
	
	public static void main (String argv[]) {
		for(int i = 1; i <= 100; i++) {
			StringBuilder output = new StringBuilder("");
			if( i % 3 == 0) {
				output.append("Fizz");
			}
			if( i % 5 == 0) {
				output.append("Buzzz");
			}
			if(output.length() == 0) {
				output.append(i);
			}
			System.out.println(output);
		}
	}

}
