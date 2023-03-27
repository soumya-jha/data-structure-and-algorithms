package com.educative.datastructures.hashtables;

import com.educative.datastructures.helper.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromLinkedList {

    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        if(list==null || list.getHeadNode()==null || list.getSize()<2){
            return;
        }
        SinglyLinkedList.Node currentNode = list.getHeadNode();
        SinglyLinkedList.Node prevNode = null;
        Set<Integer> set = new HashSet<>();
        while(currentNode!=null){
            if(!set.add((Integer)currentNode.data)){
                currentNode = currentNode.nextNode;
                prevNode.nextNode = currentNode;
            }else{
                prevNode=currentNode;
                currentNode = currentNode.nextNode;
            }
        }
    }

}

