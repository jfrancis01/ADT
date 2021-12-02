package org.code;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean wordPattern(String pattern, String s) {
        HashMap<String, String> map = new HashMap<String, String>();
        String[] words = s.split(" ");
        char  c = 'a';
        StringBuilder sb = new StringBuilder("");
        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word , String.valueOf(c));
                c++;
            }
            if(s.contains(word)){
                sb.append(map.get(word));
            }
        }
        
        return pattern.equals(sb.toString());
    }

}
