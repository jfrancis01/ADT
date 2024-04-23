package org.code;

public class GCD {

	public static void main(String[] args) {
		GCD gcdObj = new GCD();
		int a = 1785;
		int b = 546;
		int c ;
		if ( a > b) {
			c = gcdObj.gcd(1785, 546);
		}
		else {
			c = gcdObj.gcd(b, a);
		}
		
		System.out.println("The GCD is: " + c );
		
		
	}
	
	public int gcd(int a, int b) {
		if( a % b == 0 ) {
			return b;
		}
		return gcd(b, a % b);
	}

}
