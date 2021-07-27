package org.code;

public class HappyNumber {

    public static void main(String argv[]){
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if(n == 1) return true;
        if(n < 10 && n != 1) return false;
        int val = 0;
        while( n > 0){
            val+= Math.pow(n%10, 2);
            n = n/10;
        }
        System.out.println(val);
        return isHappy(val);
    }
}
