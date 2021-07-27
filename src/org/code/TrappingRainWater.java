package org.code;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trw.trap(height));
	}
	
	public int trap(int[] height) {
        int total_water =  0;
        //for each index find the left and right walls greater than the correct ndex
        int pos = 0;
        int index = 0;
        for(pos= 0;  pos<height.length; pos++){
            int left_tower = Integer.MIN_VALUE;
            int right_tower = Integer.MIN_VALUE;
            index = pos;
            while(index >= 0){
                if(height[index] > height[pos]){
                    left_tower = Math.max(left_tower, height[index]);
                }
                index--;
            }
            index = pos;
            while(index <= height.length - 1){
                if(height[index] > height[pos]){
                    right_tower = Math.max(right_tower, height[index]);
                }
                index++;
            }
            if(left_tower > Integer.MIN_VALUE && right_tower > Integer.MIN_VALUE) {
            	int volume =  Math.min(left_tower, right_tower) - height[pos];
            	total_water +=volume;
            }
        }
        
        return total_water;
    }

}
