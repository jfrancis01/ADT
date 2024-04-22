package org.code;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		// 5, 10 , -5
		//8, -8
		//10, 2, -5
		AsteroidCollision ac = new AsteroidCollision();
		int[] ans = ac.asteroidCollision(new int[] {5, 10, -5});
		Arrays.stream(ans).forEach(x -> System.out.print(x + " "));

	}
	
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int i, size;
        for( i = 0; i < asteroids.length; i++){
           while(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
        	   int diff = stack.peek() + asteroids[i];
        	   if(diff < 0) {
        		   stack.pop();
        	   }
        	   else if (diff > 0){
        		   asteroids[i] = 0;
        	   }
        	   else {
        		   asteroids[i] = 0;
        		   stack.pop();
        	   }
           }
           if(asteroids[i] > 0 || asteroids[i] < 0) {
        	   stack.add(asteroids[i]);
           }
        }
        size = stack.size();
        int[] ans = new int[size];
        for(i = size - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }

}
