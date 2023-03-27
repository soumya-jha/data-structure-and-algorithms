package com.educative.grokking.kwaymerge;

import com.educative.grokking.helper.HeapNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumber {

    public static void main(String[] args) {
        Integer[] arr1 = {2, 6, 8};
        Integer[] arr2 = {3, 6, 10};
        Integer[] arr3 = {5, 8, 11};
        List<Integer[]> lists = new ArrayList<>();
        lists.add(arr1);
        lists.add(arr2);
        lists.add(arr3);
        System.out.println(findKthSmallestNumber(lists, 6));

    }

    private static int findKthSmallestNumber(List<Integer[]> lists, int k){
        int kthSmallest = 0;
        Comparator<HeapNode> heapNodeComparator = Comparator.comparingInt(o -> lists.get(o.listIndex)[o.elementIndex]);
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(heapNodeComparator);
        //Add to minHeap
        int listNumber = 0;
        for (Integer[] arr:lists
             ) {
            if(arr.length==0){
                listNumber++;
                continue;
            }
            minHeap.add(new HeapNode(0,listNumber));
            listNumber++;
        }
        //Poll from minHeap until kth element is found
        int n=0;
        while (!minHeap.isEmpty() && n<k){
            HeapNode node = minHeap.poll();
            kthSmallest = lists.get(node.listIndex)[node.elementIndex];
            node.elementIndex++;
            //Add the node again to minHeap with incremented elementIndex
            if(lists.get(node.listIndex).length> node.elementIndex){
                minHeap.add(node);
            }
            n++;
        }
        return kthSmallest;
    }
}
