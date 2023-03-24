package org.code;

public class Substring {

	public static void main(String[] args) {
		String str = "abcd";
		String output = str.substring(0, 0) + "z" + str.substring(1);
		System.out.println(output);

	}
}
