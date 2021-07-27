package org.code;

public class StraightLine {
	
	public static void main(String argv[]) {
		int[][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
				//{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.println(checkStraightLine(coordinates));
	}
	
	public static boolean checkStraightLine(int[][] coordinates) {
		double[] slopes = new double[coordinates.length - 1];
        for(int i = 0; i<coordinates.length - 1; i++){
        	double x1 = coordinates[i][0];
        	double y1 = coordinates[i][1];
        	double x2 = coordinates[i+1][0];
        	double y2 = coordinates[i+1][1];
        	slopes[i] =  slope(x1, y1, x2, y2);
        	System.out.println(slopes[i]);
        }
        return verifySlopes(slopes);
    }
	
	public static double slope(double x1, double y1, double x2, double y2 ) {
		double y = y2 - y1;
		double x = x2 - x1;
		return y/x;
	}
	
	public static boolean verifySlopes(double[] slopes) {
		for(int i = 0; i < slopes.length - 1; i++) {
			if(slopes[i] != slopes[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
