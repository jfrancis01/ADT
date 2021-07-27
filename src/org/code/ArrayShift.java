package org.code;

public class ArrayShift {

    public static void main(String argv[]){
        String  s = "abc";
        int[][] matrix = {{0, 1}, {1, 2}};
        for(int i = 0; i < matrix.length; i++){
            //for(int j = 0; j < matrix[i].length ; j++){
                int direction = matrix[i][0];
                int amount = matrix[i][1];
                s = shift(s, direction, amount);
            //}
        }
        System.out.println("Output: " +s);
    }

    public static String shift(String s, int direction, int amount){
        int start =  0;
        int end = s.length() - 1;
        StringBuffer buffer = new StringBuffer(s);
        for(int i = 1; i <=amount; i++){
            if(direction == 0){
                String c = String.valueOf(buffer.charAt(start));
                buffer.deleteCharAt(start);
                buffer.append(c);
            }
            else{
                String c = String.valueOf(buffer.charAt(end));
                buffer.deleteCharAt(end);
                buffer.insert(0, c);
            }
        }
        return buffer.toString();
    }
}
