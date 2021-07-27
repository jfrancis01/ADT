package org.code;

import java.util.Arrays;

public class DuplicateZeros {
	
	public static void main (String argv[]) {
		int[] arr = {0,4,1,0,0,8,0,0,3};
		DuplicateZeros.duplicateZeros(arr);
	}
	
	public static void duplicateZeros(int[] arr) {
        int pos = 0;
        int size = arr.length;
        int index;
        boolean nextIsZero = false;
        for(pos = 0; pos < size; pos++ ){
        	nextIsZero = false;
            if(arr[pos] == 0){
            	if(pos + 1<= size - 1 && arr[pos + 1] == 0 ) {
            		nextIsZero = true;
            	}
                index = size - 1;
                 //check if index < pos
                while(index > pos){
                	if(index + 1 <= size - 1) {
                		arr[index + 1] = arr[index];
                	}
                    index--;
                }
                //change the next position to 0
                if(pos + 1 <= size - 1){
                    arr[pos + 1] = 0;
                }
                if(!nextIsZero) {
                    pos+= 2;
                }
            }
            printArray(arr);
            System.out.println();
        }
    }
	
	public static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(x->System.out.print(x + " "));
	}
}
