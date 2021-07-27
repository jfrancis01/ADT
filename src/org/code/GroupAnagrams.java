package org.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String argv[]){
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new LinkedList<List<String>>();
        for(String str : strs){
            String key = returnSorted(str);
            if(!map.containsKey(key)){
                map.put(key, new LinkedList<String>());
                LinkedList<String> temp = (LinkedList<String>) map.get(key);
                temp.add(str);
                map.put(key, temp);
            }
            else{
                LinkedList<String> temp = (LinkedList<String>) map.get(key);
                temp.add(str);
                map.put(key, temp);
            }
        }
        for(List<String> tempList : map.values()){
            result.add(tempList);
        }

        return result;
    }

    public static String returnSorted(String str){
        if(!str.isBlank() && !str.isEmpty()){
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            return String.valueOf(characters);
        }
        return "";
    }

}
