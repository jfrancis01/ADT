package org.code;

public class UglyNumbersIII {

	public static void main(String[] args) {
		UglyNumbersIII ugiii = new UglyNumbersIII();
		long startTime = System.currentTimeMillis();
		System.out.println(ugiii.nthUglyNumber(1000000000, 2 , 217983653, 336916467));
		long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Run Time: " + totalTime);

	}
	public int nthUglyNumber(int n, int a, int b, int c) {
        int count  = 0;
        for(int  i = 2; i <= 2000000000; i++){
            if( i % a == 0 || i % b == 0 || i % c == 0){
                count++;
                if(count == n) return i;
            }
        }
        return count;
    }

}
