package org.code;

public class ValidStartingCity {

	public static void main(String[] args) {
		int[] distances = {30, 25, 5, 100, 40};
		int[] fuel = {3, 2, 1, 0, 4};
		int mpg = 20;
		ValidStartingCity vsc = new ValidStartingCity();
		System.out.println(vsc.validStartingCity(distances, fuel, mpg));
		
	}

	public int validStartingCity(int[] distances, int[] fuel, int mpg) {
		int  index, pos, visited = 0;
		for(index = 0; index < distances.length; index++) {
			int tank = 0;
			visited = 0;
			pos = index;
			tank+= mpg * fuel[index];
			while(tank >= distances[pos] && visited != distances.length) {
				tank -= distances[pos];
				pos++;
				visited++;
				if(pos >= distances.length) {
					pos = 0;
				}
				tank += fuel[pos] * mpg;
			}
			if(visited == distances.length) {
				return index;
			}
		}
		return -1;
	}

}
