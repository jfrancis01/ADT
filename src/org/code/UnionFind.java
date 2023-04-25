package org.code;

public class UnionFind {
	int[] root;

	public static void main(String[] args) {
		int size = 10;
		UnionFind uf = new UnionFind(size);
		uf.union(1, 2);
		uf.union(2, 5);
		uf.union(5, 6);
		uf.union(6, 7);
		uf.union(3, 8);
		uf.union(8, 9);
		System.out.println(uf.connected(1, 5)); // true
		System.out.println(uf.connected(5, 7)); // true
		System.out.println(uf.connected(4, 9)); // false
		// 1-2-5-6-7 3-8-9-4
		uf.union(9, 4);
		System.out.println(uf.connected(4, 9)); // true

	}

	public UnionFind(int size) {
		// initial, you have a set amount of vertices with
		// each of them as their respective roots!
		root = new int[size];
		for (int i = 0; i < 10; i++) {
			root[i] = i;
		}
	}

	public int find(int val) {
		return root[val];
	}

	/**
	 * This is essentially connecting or making two independent vertices part of the
	 * same set and choosing a head
	 * 
	 * @param x
	 * @param y
	 */
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			for (int i = 0; i < root.length; i++) {
				if (root[i] == rootY) {
					root[i] = rootX;
				}
			}
		}
	}

	/**
	 * If the roots of the nodes are the sames then two vertices are connected or
	 * they essentially belong to the same set
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}

}
