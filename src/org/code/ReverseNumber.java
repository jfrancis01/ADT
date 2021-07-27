package org.code;

public class ReverseNumber {
	
	//-2147483648 to 2147483647
	
	public static void main(String argv[]) {
		int  num = -1000;
		int reverse = reverse(num);
		System.out.println(reverse);
	}
	
	public static int reverse(int num) {
		int reverse  = 0 ;
		while(num != 0) {
			int r = num % 10;
			num  = num/10;
			if(reverse > Integer.MAX_VALUE/10 || reverse > Integer.MAX_VALUE/10 && r > 7) return 0;
			if(reverse < Integer.MIN_VALUE/10 || reverse > Integer.MIN_VALUE/10 && r < -8) return 0;
			reverse = reverse * 10 + r;
		}
		return reverse;
	}

}


/* r
 * public int reverse(int x) {
int digit=0;
long num=0;
long factor =10;
while(x!=0){
digit=x%10;
num=num*factor+digit;
x=x/10;
if(num< Integer.MIN_VALUE || num > Integer.MAX_VALUE){
return 0;
}
}
return (int)num;
}
 */
