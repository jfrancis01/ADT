package org.code;

public class CicularPath {
	
	public static void main(String argv[]) {
		String path = "GL";
		String newPath = path + path + path + path;
		System.out.println(isCircularPath(0, newPath, 0, 0, 0));
	}
	
	public static boolean isCircularPath(int move, String path, int x, int y, int direction) {
		if(move >= path.length()) {
			return (x == 0 && y == 0);//return true only if we are back to 0,0
		}
		int nextX = x, nextY = y;
		char c = path.charAt(move);
		if( c == 'L') {
			direction += 90;
		}
		else if(c == 'R') {
			direction += 270;
		}
		else {
			switch(direction) {
			case 0: nextX++;
					break;
				
			case 90:nextY++;
					break;
			
			case 180:nextX--;
					break;
			
			case 270:nextY--;
					break;
			
			}
		}
		direction = direction % 360;
		if(isCircularPath(move + 1, path, nextX, nextY, direction)) {
			return true;
		}
		return false;
	}

}
