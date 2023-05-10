package org.code;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII {

	public static void main(String[] args) {
		int[][] maze = {{0,0,0	,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
		int[] start = {4,3};
		int[] destination = {0,1};
		MazeII mii = new MazeII();
		System.out.println(mii.shortestDistance(maze, start, destination));
	}

	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;
		//Initialize a boolean visited array
		boolean [][] visited = new boolean[m][n];
		//Queue is used for the BFS algorithm
		Queue<String[]> queue = new LinkedList<String[]>();
		//we initialize the start posititon object with coordinates, direction and # of moves
		String[]pos = {String.valueOf(start[0]), String.valueOf(start[1]), "", "0"};
		queue.add(pos);
		while(!queue.isEmpty()) {
			String[] current = queue.poll();
			int i = Integer.parseInt(current[0]);
			int j = Integer.parseInt(current[1]);
			String dir = current[2];
			int moves = Integer.parseInt(current[3]);
			//here if we reached the destination and either the next square in the direction
			//we are facing is a wall or it hits the boundary then we return the moves!
			if(i == destination[0] && j == destination[1]) {
				if(dir.equals("L") && (j - 1 < 0 || maze[i][j - 1] == 1)) {
					return moves;
				}
				else if(dir.equals("R") && (j + 1 >= n || maze[i][j + 1] == 1 )) {
					return moves;
				}
				else if(dir.equals("U") && (i - 1 < 0 || maze[i - 1][j] == 1 )) {
					return moves;
				}
				else {
					if(dir.equals("D") && (i + 1 >= m || maze[i + 1][j] == 1 )) {
						return moves;
					}
				}
			}
			visited[i][j] = Boolean.TRUE;
			//now we analyze the current position and depending on the direction, keep moving in
			//that direction until you hit a wall. 
			if(dir.equals("L") && j - 1 > 0 && maze[i][j - 1] == 0 && !visited[i][j - 1]) {
				String[] newMove =  {String.valueOf(i), String.valueOf(j-1), "L", String.valueOf(moves + 1) };
				queue.add(newMove);
			}
			else if(dir.equals("R") && j + 1 < n && maze[i][j + 1] == 0 && !visited[i][j + 1]) {
				String[] newMove =  {String.valueOf(i), String.valueOf(j+1), "R", String.valueOf(moves + 1) };
				queue.add(newMove);
			}
			else if(dir.equals("U") && i - 1 > 0 && maze[i - 1][j] == 0 && !visited[i - 1][j]) {
				String[] newMove =  {String.valueOf(i - 1), String.valueOf(j), "U", String.valueOf(moves + 1) };
				queue.add(newMove);
			}
			else if(dir.equals("D") && i + 1 < m && maze[i + 1][j] == 0 && !visited[i + 1][j]) {
				String[] newMove =  {String.valueOf(i + 1), String.valueOf(j), "D", String.valueOf(moves + 1) };
				queue.add(newMove);
			}
			//here we check to see if we hit a wall and add connections that are not walls and have not been visited
			else if(dir.equals("L") && (j - 1 < 0 || maze[i][j - 1] == 1)) {
				if(i - 1 >= 0 && !visited[i - 1][j]) {
					String[] newMove =  {String.valueOf(i - 1), String.valueOf(j), "U", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(i + 1 < m  && !visited[i + 1][j]) {
					String[] newMove =  {String.valueOf(i + 1), String.valueOf(j), "D", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
			}
			else if(dir.equals("R") && (j - 1 < 0 || maze[i][j - 1] == 1)) {
				if(i - 1 >= 0 && !visited[i - 1][j]) {
					String[] newMove =  {String.valueOf(i - 1), String.valueOf(j), "U", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(i + 1 < m && !visited[i + 1][j]) {
					String[] newMove =  {String.valueOf(i + 1), String.valueOf(j), "D", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
			}
			else if(dir.equals("U") && (i - 1 < 0 || maze[i-1][j] == 1)) {
				if(j - 1 >= 0  && !visited[i][j - 1]) {
					String[] newMove =  {String.valueOf(i), String.valueOf(j-1), "L", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(j + 1 < n && !visited[i][j + 1]) {
					String[] newMove =  {String.valueOf(i), String.valueOf(j+1), "R", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
			}
			else if(dir.equals("") && (i == start[0] && j == start[1])) {
				if(i-1 > 0 && maze[i-1][j] != 1) {// UP
					String[] newMove =  {String.valueOf(i - 1), String.valueOf(j), "U", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(i + 1 < m && maze[i + 1][j] != 1) {// Up
					String[] newMove =  {String.valueOf(i + 1), String.valueOf(j), "D", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(j + 1 > n && maze[i][j + 1] != 1) {// Right
					String[] newMove =  {String.valueOf(i), String.valueOf(j + 1), "R", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(j - 1 > 0 && maze[i][j - 1] != 1) {// Left
					String[] newMove =  {String.valueOf(i), String.valueOf(j-1), "L", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
			}
			else {
				if(j - 1 >= 0 && !visited[i][j - 1]) {
					String[] newMove =  {String.valueOf(i), String.valueOf(j-1), "L", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
				if(j + 1 < n && !visited[i][j + 1]) {
					String[] newMove =  {String.valueOf(i), String.valueOf(j+1), "R", String.valueOf(moves + 1) };
					queue.add(newMove);
				}
			}
		}
		return -1;

	}

}
