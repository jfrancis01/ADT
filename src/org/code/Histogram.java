package org.code;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Histogram {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Brute force approach
     * For each bar we stop as soon as we encounter a bar smaller than the current bar
     * That is, we search for all bars greater than the current bar to the left and right
     * This means that the area is calculated assuming that the current bar is the one with
     * the minimum height!!!!!!!
     * @param h
     * @return
     */
    static long largestRectangle(int[] h) {
        int max_area = 0;
        for(int i =0; i<h.length; i++) {
            int j =0, k=0;
            int right = 0 ;
            int left = 0;
            //Neighbour to the right
            for(j = i + 1; j < h.length; j++) {
                if (h[j] >= h[i]) {
                    right++;
                }
                else {
                    break;
                }
            }
            //Neighbor to the left
            for(k = i - 1; k >=0 ; k--) {
                if(h[k] >= h[i]) {
                    left++;
                }
                else {
                    break;
                }
            }

            if(right == 0 && left == 0) {
                max_area = max_area > h[i]? max_area:h[i];
            }
            else {
                max_area = Math.max(max_area, h[i] * (right + left + 1));
            }
        }
        return max_area;
    }

    /**
     * Stack implementation with O(n)
     * @param h
     * @return
     */
    static long largestRectangle2(int[] h) {
        Stack<Integer> stack = new Stack<Integer>();
        int area = Integer.MIN_VALUE;
        int top;
        int right;
        for(right = 0; right < h.length; right ++) {

            //if stack is empty or the new height is greater than the height
            //at the top, push the index on to the stack
            if(stack.isEmpty() || h[right] > h[stack.peek()]) {
                stack.push(right);
            }
            //if we encounter a number that is less than the number on the top
            //of the stack, we know it is an obstruction to the previous value
            else {
                while(!stack.empty()) {
                    top = stack.pop();

                    if(stack.isEmpty()) {
                        area = Math.max(area, h[top] * right);
                    }
                    else {
                        area = Math.max(area, h[top] * (right - stack.peek() - 1));
                    }
                    if(stack.empty() || h[stack.peek()] < h[right]) {
                        //push the value that you just encountered on to the stack
                        stack.push(right);
                        break;
                    }
                }
            }

        }
        //here we need to check for the remaining elements if any
        //that maybe left behind in the stack
        while(!stack.empty()) {
            top = stack.pop();
            if(stack.isEmpty()) {
                area = Math.max(area, h[top] * right );
            }
            else {
                area = Math.max(area, h[top] * (right - stack.peek() - 1));
            }
        }
        return area;
    }


    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle2(h);
        System.out.println(result);

        scanner.close();
    }

}
