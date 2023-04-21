package com.educative.grokking.kwaymerge;

import com.educative.grokking.helper.LinkedList;
import com.educative.grokking.helper.LinkedListNode;
import com.educative.grokking.helper.ListHeapNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    //INCOMPLETE
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        LinkedListNode returnList = new LinkedListNode(0);
        Comparator<ListHeapNode> listNodeComparator = Comparator.comparing(o -> o.data);
        PriorityQueue<ListHeapNode> minHeap = new PriorityQueue<>(listNodeComparator);
        int listNumber = 0;
        for (LinkedList list : lists) {
            if (list == null) {
                listNumber++;
                continue;
            }
            minHeap.add(new ListHeapNode(list.head.data, listNumber));
            listNumber++;
        }

        while(!minHeap.isEmpty()){
            ListHeapNode node = minHeap.poll();
            //returnList = new LinkedListNode();
        }
        return returnList;
    }
}
