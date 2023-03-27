package com.educative.datastructures.hashtables;

import com.educative.datastructures.helper.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {

    //performs union of two lists
    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if(list1!=null && list1.getHeadNode()!=null){
            createResultList(list1.getHeadNode(), result);
        }
        if(list2!=null && list2.getHeadNode()!=null){
            createResultList(list2.getHeadNode(), result);
        }
        removeDuplicatesWithHashing(result);
        return result;
    }

    public static <T> void createResultList(SinglyLinkedList.Node currentNode, SinglyLinkedList<T> result){
        while(currentNode!=null){
            result.insertAtEnd((T) currentNode);
            currentNode = currentNode.nextNode;
        }
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if(list1==null || list1.getHeadNode()==null
                ||list2==null || list2.getHeadNode()==null){
            return result;
        }
        SinglyLinkedList.Node currentNode = list2.getHeadNode();
        Set<Integer> set = new HashSet<>();
        while(currentNode!=null){
            set.add((Integer)currentNode.data);
            currentNode = currentNode.nextNode;
        }
        currentNode = list1.getHeadNode();
        while(currentNode!=null){
            if(set.contains(currentNode.data)){
                result.insertAtEnd((T) currentNode);
                set.remove(currentNode.data);
            }
            currentNode = currentNode.nextNode;
        }
        return result;
    }

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
