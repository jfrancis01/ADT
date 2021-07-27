package org.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String argv[]){
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1, o2);
            }
        });

        for(int stone :stones ) maxHeap.add(stone);
        while(maxHeap.size() != 1){
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            if(s1 != s2){
                maxHeap.add(Math.abs(s1-s2));
            }
        }
        return maxHeap.poll();
    }
}
