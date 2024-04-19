package org.code;

import java.util.Arrays;

public class ProductArray {

	public static void main(String[] args) {
		ProductArray pa = new ProductArray();
		int[] nums = {1, 2, 3, 4};
		Arrays.stream(pa.productExceptSelf(nums)).forEach(x -> System.out.print(x + " "));
	}
	
	public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] product = new int[nums.length];
        int i, j;
        int prev = 1;
        int suff = 1;
        for(i = 0; i < nums.length; i++){
            prefix[i] = prev * nums[i];
            prev = prefix[i];
        }
        for(j = nums.length - 1; j >=0; j--){
            suffix[j] = suff * nums[j];
            suff = suffix[j];
        }
        int left = 1;
        int right = 1;
        
        for(i = 0; i < product.length; i++) {
        	left = i - 1 < 0 ? 1 : prefix[i - 1];
        	right = i + 1 >= nums.length ? 1 : suffix[i + 1];
        	
        	product[i] = left * right;
        }
         
        
        return product;
    }

}
