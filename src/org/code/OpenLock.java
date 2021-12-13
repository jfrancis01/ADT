package org.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {
	
	HashSet<String> visited = new HashSet<String>();
	HashSet<String>  deadends = new HashSet<String>();
	
    public int openLock(String[] deadends, String target) {
        int index = 0;
        for(String deadend : deadends) {
        	this.deadends.add(deadend);
        }
        String sb = new String("0000");
        if(this.deadends.contains(sb)) return -1;
        return openLockHelper(deadends, target, index, sb, 0);
        
    }
    public int openLockHelper(String[] deadends, String target, int index, String sb, int count){
    	Queue<String> q = new LinkedList<String>();
    	q.add(sb);
    	this.deadends.add(sb);
    	int level = 0;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(size > 0) {
    			String temp = q.poll();
    			if(temp.equals(target)) return level;
    			for(int i = 0; i < temp.length(); i++) {
    				char c = temp.charAt(i);
    				char upC = c;
    				if(upC == '9') {
    					upC = '0';
    				}
    				else {
    					++upC;
    				}
    				String upString = temp.substring(0, i) + upC + temp.substring(i + 1);
    				if(!this.deadends.contains(upString)) {
    					q.add(upString);
    					this.deadends.add(upString);
    				}
    				char downC = c;
    				if(downC == '0') {
    					downC = '9';
    				}
    				else {
    					--downC;
    				}
    				String downString = temp.substring(0, i) + downC + temp.substring(i + 1);
    				if(!this.deadends.contains(downString)) {
    					q.add(downString);
    					this.deadends.add(downString);
    				}
    			}
    			size--;
    		}
    		++level;
    	}
    	return -1;
    } 

	public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        OpenLock op = new OpenLock();
        System.out.println(op.openLock(deadends, "0202"));
	}

}
