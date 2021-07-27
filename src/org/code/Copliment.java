package org.code;

public class Copliment {
	
	public static void main(String argv[]) {
		int n = 4;
		System.out.println(compliment(n));
	}
	
	public static int compliment(int n) {
		StringBuffer binary = new StringBuffer("");
		int remainder = 0;
		while(n > 0) {
			remainder = n%2;
			binary.insert(0, String.valueOf(remainder));
			n = n/2;
		}
		for(int i = 0; i < binary.length(); i++) {
			if(String.valueOf(binary.charAt(i)).equals("1")) {
				binary.replace(i, i + 1, "0");
			}
			else {
				binary.replace(i, i + 1, "1");
			}
		}
		return Integer.parseInt(binary.toString(), 2);
	}

}
