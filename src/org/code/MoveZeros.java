package org.code;

public class MoveZeros {

    public static void main(String argv[]){
        //int[] nums = {0, 1, 0, 3, 12}
        int[] nums = {1};
        moveZeroes(nums);
        for(int i : nums){
            System.out.println(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int start = 0;
        int index = 0;
        int temp;
        while(start <= nums.length - 1){
            if(nums[start]== 0){
                index = start;
                while(index <= nums.length - 1 ){
                    if(nums[index] != 0){
                        temp = nums[index];
                        nums[index] = nums[start];
                        nums[start] = temp;
                        break;
                    }
                    else{
                        index++;
                    }
                }
            }
            start++;
        }
    }
}
