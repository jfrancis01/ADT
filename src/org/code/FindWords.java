package org.code;

public class FindWords {
	
	public static void main(String argv[]) {
		 String[] words = {"boygirdlggnh","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo"};
		 String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
		 System.out.println(countCharacters(words, chars));
	}
	
	public static int countCharacters(String[] words, String chars) {
        int sum = 0;
        for(int i = 0; i < words.length; i++){
            sum += matchFound(words[i].toCharArray(), chars);
        }
        return sum;
    }
    
    public static int matchFound(char[] charArray, String chars){
        int index = -1;
        boolean flag = true;
        for(int i = 0; i < charArray.length; i++){
        	char c = charArray[i];
            index = chars.indexOf(c);
            if(index == - 1){
                flag = false;
                break;
            }
            else{
                chars = chars.replaceFirst(Character.toString(c), "*");
            }
        }
        
        if(!flag){
            return 0;
        }
        else{
            System.out.println(String.valueOf(charArray));
            return charArray.length;
        }
    }

}
