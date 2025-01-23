package org.code;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Newspapers {
	
	public static void main(String argv[]) {
		int[] newspapers_read_times = {7,2,5,10,8};
		int num_coworkers = 2;
		Newspapers np = new Newspapers();
		System.out.println(np.newspapersSplit(newspapers_read_times, num_coworkers));
	}
	
	public int newspapersSplit(int[] newspapers_read_times, int num_coworkers) {
		int[] copy = new int[newspapers_read_times.length];
		System.arraycopy(newspapers_read_times, 0, copy, 0, newspapers_read_times.length);
		Arrays.sort(newspapers_read_times);
		int start = newspapers_read_times[newspapers_read_times.length - 1]; // minimum time
		int end = IntStream.of(newspapers_read_times).sum();
		int ans = -1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(feasible(mid,  copy, num_coworkers)) {
				ans = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return ans;
	}
	
	public boolean feasible(int mid, int[] copy, int num_coworkers) {
		int current_read_time = 0;
		int workers = 0;
		for(int i = 0; i < copy.length; i++ ) {
			if(current_read_time + copy[i]> mid) {
				current_read_time = 0;
				workers++;
			}
			current_read_time += copy[i];
		}
		if(current_read_time != 0) {
			workers++;
	    }
		return (workers <= num_coworkers);
	}
}
