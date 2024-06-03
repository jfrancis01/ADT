package org.code;

import java.util.NoSuchElementException;

public class MinHeap {
	
	private int currIndex = -1;
	private int[]arr =  null;
	private int currSize = -1;
	
	public MinHeap(int n) {
		arr = new int[n];
	}
	
	/**
	 * Check if the heap is empty using 
	 * currIndex. It is initially set to -1 to 
	 * indicate it is empty. 
	 * @return
	 */
	public boolean isEmpty() {
		return (currSize == -1);
	}
	
	
	/**
	 * Returns the # of elements in the heap
	 * @return
	 */
	public int size() {
		return currSize;
	}
	
	/**
	 * Inserts an integer into the heap at the next available index;
	 * @param val
	 * @return
	 */
	public void insert(int val) {
		if(currSize + 1 >= arr.length) System.out.println("Heap is full");
		arr[++currIndex] = val;
		++currSize;
		siftUp(currIndex, val);
		System.out.println(val + " inserted");
	}
	
	/**
	 * Deleting always removes the root node which is the first element
	 * and replace it with the last element. 
	 */
	public int delete()throws NoSuchElementException {
		int del = -1;
		if(currSize > -1 ) {
			del = arr[0];
			arr[0] = arr[currIndex];
			--currSize;
			--currIndex;
			if(currSize > 0) {
				siftDown(0);
			}
		}
		else {
			throw new NoSuchElementException();
		}
		return del;
	}
	
	private void siftDown(int index) {
		if(index < arr.length) {
			int left = (2 * index) + 1;
			int right = (2 * index) + 2;
			
			int smallest = arr[index];
			int newIndex = index;
			
			if(left < arr.length && left < currIndex && arr[left] <= arr[index]) {
				smallest = arr[left];
				newIndex = 2 * index + 1;
			}
			if(right < arr.length && right < currIndex && arr[right] <= smallest) {
				smallest = arr[right];
				newIndex = 2 * index + 2;
			}
			if(index != newIndex ) {
				int temp = arr[index];
				arr[index] = smallest;
				arr[newIndex] = temp;
				siftDown(newIndex);
			}
		}
		
	}
	
	private void siftUp(int currentIndex, int val) {
		if(currentIndex != 0) {
			int parent = (int)Math.floor((currentIndex - 1)/2);
			if(arr[parent] > arr[currentIndex]) {
				int temp = arr[parent];
				arr[parent] = val;
				arr[currentIndex] = temp;
				siftUp(parent, val);
			}
		}
	}
}
