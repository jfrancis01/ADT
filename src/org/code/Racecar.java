package org.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Racecar {

	public static void main(String[] args) {
		Racecar rc = new Racecar();
		System.out.println(rc.racecar(4));

	}

	private int racecar(int target) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] start = { 0, 0, 1 };// moves, position, speed
		HashSet<String> visited = new HashSet<String>();
		int[] curr;
		int move, pos, speed;
		queue.add(start);
		while (!queue.isEmpty()) {
			curr = queue.poll();
			move = curr[0];
			pos = curr[1];
			speed = curr[2];
			
			if (pos == target) {
				return move;
			}
			else if (visited.contains(pos + " " + speed)) {
				continue;
			}
			else{
				visited.add(pos + " " + speed);
				queue.add(new int[]{move+1,pos+speed,speed*2 });
				if(pos + speed > target && speed > 0 || 
						pos + speed < target && speed < 0) {
					queue.add(new int[] {move + 1, pos, speed > 0 ? -1:1});
				}
			}
		}
		return -1;
	}
}
