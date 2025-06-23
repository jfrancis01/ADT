package org.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class SnapshotArray {
	
	HashMap<Integer, TreeMap<Integer, Integer>> map = null;
	int snap_id = 0;
	
	public SnapshotArray(int length) {
		map = new HashMap<Integer, TreeMap<Integer, Integer>>();
		for(int i = 0; i < length; i++) {
			map.put(i, new TreeMap<Integer, Integer>());
		}
	}
	
	public void set(int index, int val) {
		TreeMap<Integer, Integer> treeMap = map.get(index);
		treeMap.put(snap_id, val);
		map.put(index, treeMap);
	}
	
	public int snap() {
		return ++snap_id;
	}
	
	public int get(int index, int snap_id) {
		TreeMap<Integer, Integer> treeMap = map.get(index);
		if(!treeMap.containsKey(snap_id)) {
			Integer ans = treeMap.floorKey(snap_id);
			if(ans == null) {
				return 0;
			}
			else {
				return treeMap.get(ans);
			}
		}
		return treeMap.get(snap_id);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
