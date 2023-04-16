package org.code;

public class BestSeat {

	public static void main(String[] args) {
		int[] seats = { 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1};
		BestSeat bs = new BestSeat();
		System.out.println(bs.bestSeat(seats));
	}

	public int bestSeat(int[] seats) {
		int best = Integer.MAX_VALUE;
		int max_space = Integer.MIN_VALUE;
		int length = seats.length;
		for (int i = 0; i < length; i++) {
			if (seats[i] == 1) {
				int pos = i + 1;
				while (pos < length) {
					if (seats[pos] == 1) {
						int space = pos - i;
						if(space > max_space) {
							max_space = space;
							int mid = i + (pos - i)/2;
							if (seats[mid] == 0) {
								best = mid;
							} 
						}
						break;
					}
					pos++;
				}
			}
		}
		return best == Integer.MAX_VALUE ? -1 : best;
	}

}
