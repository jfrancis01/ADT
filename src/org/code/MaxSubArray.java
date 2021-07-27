package org.code;

public class MaxSubArray {

    //TODO Have to try to do this using dyanmic programming O(n).
    //because right now I have an O(n)^2 run time complexity
    public static void main(String argv[]){
        //int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        //int nums[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        //int nums[] = {-1, 2, 3, -4, 5, 10};
        int nums[] = {6, -3, 11, -2, -3, 10, -5};
        System.out.println(maxSubArray(nums));
    }
    public static int  maxSubArray(int[] nums){
        int i, j, tempSum, sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(i = 0; i <nums.length; i++){
            tempSum = 0;
            sum = 0;
            for(j = i ; j<nums.length;j++){
                tempSum += nums[j];
                sum  = tempSum > sum ? tempSum : sum;
            }
            max_sum = sum > max_sum ? sum: max_sum;
        }
        return max_sum;
    }
}
