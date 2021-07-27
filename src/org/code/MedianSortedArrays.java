package org.code;

public class MedianSortedArrays {

	public static void main(String[] args) {
		int nums1[] = { 1, 2, 3, 4, 5, 6, 7 };
		int nums2[] = { 1, 2, 3, 4 };
		MedianSortedArrays msa = new MedianSortedArrays();
		double ans = msa.findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		// if length of array 2 is smaller then we swap
		if (nums2.length < nums1.length) {
			findMedianSortedArrays(nums2, nums1);
		}
		// Lengths of the arrays
		int m = nums1.length;
		int n = nums2.length;

		// start and end of smaller array
		int start = 0;
		int end = m;

		while (start <= end) {

			// partition the arrays
			int midN1 = (start + end) / 2;
			int midN2 = (m + n + 1) / 2 - midN1;

			// handle edge cases
			int maxLeftNums1 = midN1 == 0 ? Integer.MIN_VALUE : nums1[midN1 - 1];
			int minRightNums1 = midN1 == m ? Integer.MAX_VALUE : nums1[midN1];
			int maxLeftNums2 = midN2 == 0 ? Integer.MIN_VALUE : nums2[midN2 - 1];
			int minRightNums2 = midN2 == n ? Integer.MAX_VALUE : nums2[midN2];

			if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
				if ((m + n) % 2 == 0) {
					return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
				} else {
					return Math.max(maxLeftNums1, maxLeftNums2);
				}
			}
			else if(maxLeftNums1 > minRightNums2) {
				end = midN1 - 1;
			}
			else {
				start = midN1 + 1;
			}
		}
		return -1;
	}
}
