package org.code;

import java.util.Comparator;
import java.util.PriorityQueue;

//This took me a while for understanding because of various approaches that exist today to solve this
//If you have a maxHeap, how do you solve it ? vs. if you have a minHeap ?

//Anyway
/*
Use a min heap. Why ?
Because, in a min heap, if you have let's say 3 elements, the one at the root is the smallest element,
and the ones below the root are bigger or equal to the one at root.
So, the root is technically the 3rd largest element if the heap is of size 3.

Thus, for a min heap of size K, the element at the root is the Kth largest element ( from an opposite perspective )


So, how do we solve this problem ?

When a new number pops up to be added,
we add it to the heap. Let's say, the heap has now k + y elements.
If we remove everything from the min heap, all smaller y elements from the heap gets removed.
k elements remain. This way, peek() the root of the heap to return the desired value.

In the next add, heap is of size k.
Add a new value.
heap is of size k + 1.
Remove the smallest element.
Heap is of size k. peek() the root

and so on.

Now, you might be thinking, what happens to all the previous elements that were removed in the 1'st add call !!

Well, they were all SMALLER than the one at the root. So, they are useless. The big elements are always lying beneath the current root. In fact, when a new element comes, we add it first, and then poll() to make sure we are not unintentionally getting rid of incoming BIGGER numbers.

Example :


K = 5, Heap = [10,10,8,6,5,3,1,1,1,1,0], size = 11

add(6);
{
    > we add 6 to the heap
    > Heap = [10,10,8,6, 6 ,5,3,1,1,1,1,0], size = 12
    > while size != 6, poll()
    >Heap = [10,10,8,6, 6], size = 6
    > return 6 ( Minimum Element)
}

add(12);
{
    > we add 12 to the heap
    > Heap = [12, 10,10,8,6, 6], size = 7
    > while size != 6, poll()
    > Heap = [12, 10,10,8,6], size = 6
    > return 6 ( Minimum Element)
}

*/

public class HeapTest {
    public static void main(String argv[]){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1, o2);
            }
        });
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(21);
        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }
}