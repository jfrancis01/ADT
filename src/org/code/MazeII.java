package org.code;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII {
    int shortest = Integer.MAX_VALUE;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        MazeII mii = new MazeII();
        System.out.println(mii.shortestDistance(maze, start, destination));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int count = 0;
        boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
        dfs(maze, start[0], start[1], destination, visited, count);
        return shortest == Integer.MAX_VALUE ? -1 : shortest;

    }

    private void dfs(int[][] maze, int i, int j, int[] destination, boolean[][][] visited, int count) {
        if (i == destination[0] && j == destination[1]) {
            shortest = Math.min(shortest, count);
            return;
        }

        for (int k = 0; k < dirs.length; k++) {
            int[] dir = dirs[k];
            int x = i;
            int y = j;
            int newcount = count;
            while (x + dir[0] >= 0 && x + dir[0] < maze.length &&
                    y + dir[1] >= 0 && y + dir[1] < maze[0].length &&
                    maze[x + dir[0]][y + dir[1]] == 0) {
                x += dir[0];
                y += dir[1];
                newcount++;
            }
            if (!visited[x][y][k]) {
                visited[x][y][k] = true;
                dfs(maze, x, y, destination, visited, newcount);
                visited[x][y][k] = false;
            }
        }
    }

}
