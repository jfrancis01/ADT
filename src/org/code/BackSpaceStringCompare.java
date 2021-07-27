package org.code;

public class BackSpaceStringCompare {

    public static void main(String argv[]){
        //a##c, #a#c;
        //ab#c, ad#c
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    public static boolean backspaceCompare(String S, String T) {
        String s = processString(S);
        String t = processString(T);

        return s.equals(t);
    }

    public static String processString(String S){
        int spaceIndex = 0;
        while((spaceIndex = S.indexOf('#')) != -1) {
            if(spaceIndex >1) {
                S = S.substring(0, spaceIndex - 1) + S.substring(spaceIndex + 1);
            }
            else {
                S = S.substring(spaceIndex + 1);
            }
        }
        return S;
    }
}
