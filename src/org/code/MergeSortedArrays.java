package org.code;

import java.util.Arrays;

public class MergeSortedArrays {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p2 = 0;
		int p1 = 0;
		while( p2 < n && m <= nums1.length - 1) {
			if(nums2[p2] > nums1[p1]) {
				p1++;
				if(p1 >= m ) {
					nums1[p1] = nums2[p2];
					p2++;
					m++;
				}
			}
			else if(nums2[p2] <= nums1[p1]) {
				//here we shift
				int pos = nums1.length - 2;
				while( pos >= p1) {
					nums1[pos + 1] = nums1[pos];
					pos--;
				}
				nums1[p1] = nums2[p2];
				p2++;
				p1++;
				m++;
			}
			else {
				//do nothing
			}
		}
	}
	
	public static void main(String argv[]) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;
		
		MergeSortedArrays msa = new MergeSortedArrays();
		msa.merge(nums1, m, nums2, n);
		Arrays.stream(nums1).forEach(x->System.out.print(x + " "));
	}

}

