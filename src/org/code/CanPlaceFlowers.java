package org.code;

//Test
public class CanPlaceFlowers {

	public static void main(String argv[]) {
		CanPlaceFlowers cpf = new CanPlaceFlowers();
		int[] arr = {1, 0, 0, 0, 1};
		int n = 1;
		System.out.println(cpf.canPlaceFlowers(arr, n));
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n > flowerbed.length)
			return false;
		if (n == 1 && flowerbed.length == 1) {
			return flowerbed[0] == 0;
		}
		if (n == 0)
			return true;
		int i = -1;
		for (i = 0; i < flowerbed.length; i++) {
			if (n > 0) {
				if (flowerbed[i] == 0) {
					// now check left and right
					if (i == 0 && flowerbed.length >= 2) {
						if (flowerbed[i + 1] == 0) {
							n = n - 1;
							flowerbed[i] = 1;// plant the flower
							i = i + 1;
						}
					} else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
						n = n - 1;
						flowerbed[i] = 1;// plant the flower
						i = i + 1;
					} else {
						if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
							n = n - 1;
							flowerbed[i] = 1;// plant the flower
							i = i + 1;
						}
					}
				}
			}

		}
		if (n == 0)
			return true;
		return false;
	}

}
