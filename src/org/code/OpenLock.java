package org.code;

import java.util.HashSet;

public class OpenLock {
	
	int steps = Integer.MAX_VALUE;
	HashSet<String> map = new HashSet<String>();
    public int openLock(String[] deadends, String target) {
        int index = 0;
        StringBuilder sb = new StringBuilder("0000");
        openLockHelper(deadends, target, index, sb, 0, map);
        return steps;
    }
    public void openLockHelper(String[] deadends, String target, int index, StringBuilder sb, int count, HashSet<String> map){
        if(isDeadEnd(sb.toString(), deadends)) {
        	 return;
        }
        if(sb.toString().equals(target)) {
        	steps = Math.min(count, steps);
        	return;
        }
        
        for(int i = index; i < sb.length(); i++) {
        	char c = sb.charAt(i);
        	char d = c;
        	if(d == '9') {
        		d = '0';
        	}else {
        		++d;
        	}
        	sb.replace(i, i + 1, d + "");
        	if(map.contains(sb.toString())) {
        		return;
        	}
        	map.add(sb.toString());
        	openLockHelper(deadends, target, i, sb, ++count, map);
        	sb.replace(i, i + 1, c + "");
        }
    } 

	public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        OpenLock op = new OpenLock();
        System.out.println(op.openLock(deadends, "0202"));
	}
	
	private boolean isDeadEnd(String combo, String[] deadends) {
		for(String deadend : deadends) {
			if(combo.equals(deadend)) {
				return true;
			}
		}
		return false;
	}

}
