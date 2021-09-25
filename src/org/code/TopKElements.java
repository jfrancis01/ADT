package org.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKElements {

	public static void main(String[] args) {
		TopKElements topK = new TopKElements();
		int[] nums = {1,1,1,2,2,3};
		int[] ans = topK.topKFrequent(nums, 2);
		for(int val : ans) {
			System.out.print(val + " ");
		}
	}
	class Element{
		Integer val = 0;
		Integer freq  = 0;
	}
	public int[] topKFrequent(int[] nums, int k) {
		Arrays.sort(nums); // O(nlogn)
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(!hmap.containsKey(nums[i])) {
				hmap.put(nums[i], 1);
			}
			else {
				hmap.put(nums[i], hmap.get(nums[i]) + 1);
			}
		}
		Set<Integer> Keys = hmap.keySet();
		PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {

			@Override
			public int compare(Element arg0, Element arg1) {
				return arg0.freq > arg1.freq ? -1: 1;
			}
		});
		
		for(int key : Keys) {
			Element e = new Element();
			e.val = key;
			e.freq = hmap.get(key);
			pq.add(e);
		}
		int[] ans = new int[k];
		int index= 0;
		for(int i = 1; i <=k; i++) {
			ans[index] = pq.poll().val;
			index++;
		}
		return ans;
	}
}
