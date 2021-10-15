package org.code;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	
	List<Integer> ans = new ArrayList<Integer>();
	
    public List<Integer> partitionLabels(String s) {
    	
    	partitionLabelsHelper(s, 0);
    	for(int i = 0; i < ans.size(); i++) {
    		System.out.print(ans.get(i) + " ");    	}
    	return ans;
        
    }
    
    private boolean partitionLabelsHelper(String s, int start) {
    	if(start == s.length()) {

    		return true;
    	}
    	
    	for(int end = start; end< s.length(); end++) {
    		if(checkLabel(s.substring(start, end + 1), s.substring(end + 1)) && partitionLabelsHelper(s, end + 1)) {
  
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    private boolean checkLabel(String toCheck, String remaining) {
    	for(int i  = 0; i < toCheck.length(); i++) {
    		if(remaining.indexOf(toCheck.charAt(i)) != -1) {
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
