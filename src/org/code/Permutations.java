package org.code;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	private static List<List<Integer>> answer = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Permutations.getPermutations(list);
	}

	public static List<List<Integer>> getPermutations(List<Integer> array) {
		List<Integer> combo = new ArrayList<Integer>();
		helper(array, combo);
		return answer;
	}

	private static void helper(List<Integer> array, List<Integer> combo) {
		if (array.size() == 0) {
			ArrayList<Integer> current = new ArrayList<Integer>();
			current.addAll(combo);
			answer.add(current);
			return;
		}
		for (int i = 0; i < array.size(); i++) {
			int val = array.remove(i);
			combo.add(val);
			helper(array, combo);
			combo.remove(combo.size() - 1);
			array.add(i, val);
		}
	}

}
