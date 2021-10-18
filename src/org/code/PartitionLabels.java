package org.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels {

	List<Integer> ans = new ArrayList<Integer>();

	public List<Integer> partitionLabels(String s) {

		partitionLabelsHelper(s, 0);
		Collections.reverse(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		return ans;

	}

	private boolean partitionLabelsHelper(String s, int start) {
		if (start == s.length()) {

			return true;
		}

		for (int end = start; end < s.length(); end++) {
			String word = s.substring(start, end + 1);
			if (checkLabel(word, s.substring(end + 1)) && partitionLabelsHelper(s, end + 1)) {
				ans.add(end - start + 1);
				return true;
			}
		}

		return false;
	}

	private boolean checkLabel(String toCheck, String remaining) {
		for (int i = 0; i < toCheck.length(); i++) {
			if (remaining.indexOf(toCheck.charAt(i)) != -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PartitionLabels pl = new PartitionLabels();
		pl.partitionLabels("ababcbacadefegdehijhklij");
	}

}
