package org.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

	private PriorityQueue<Integer> min_heap = null;
	private PriorityQueue<Integer> max_heap = null;

	public MedianFinder() {
		min_heap = new PriorityQueue<Integer>();
		max_heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? -1 : 1;
			}
		});

	}

	public void addNum(int num) {
		// if both are empty then add to the min
		if (min_heap.isEmpty() && max_heap.isEmpty()) {
			max_heap.add(num);
		} else if (!max_heap.isEmpty() && num > max_heap.peek()) {
			min_heap.add(num);
		} else {
			max_heap.add(num);
		}
		
		//check if the heaps are off by 1
		if(Math.abs(max_heap.size() - min_heap.size()) > 1){
			if(max_heap.size() > min_heap.size()) {
				min_heap.add(max_heap.poll());
			}
			else {
				max_heap.add(min_heap.poll());
			}
		}

	}

	public double findMedian() {
		if (max_heap.size() == min_heap.size()) {
			return (double) (max_heap.peek() + min_heap.peek()) / 2;
		}
		return (double) max_heap.size() > min_heap.size() ? max_heap.peek() : min_heap.peek();
	}

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		mf.addNum(4);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(7);
		System.out.println(mf.findMedian());
		mf.addNum(8);
		System.out.println(mf.findMedian());
		mf.addNum(9);
		System.out.println(mf.findMedian());
		mf.addNum(10);
		System.out.println(mf.findMedian());
	}

}
