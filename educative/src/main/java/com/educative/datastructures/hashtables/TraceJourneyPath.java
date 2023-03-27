package com.educative.datastructures.hashtables;

import java.util.Iterator;
import java.util.Map;

public class TraceJourneyPath {
    public static void main(String[] args) {

    }

    public static String tracePath(Map<String,String> map) {
        StringBuilder result = new StringBuilder();
        String first = null;
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String current = iterator.next();
            if(!map.containsValue(current)){
                first = current;
                break;
            }
        }
        String current = first;
        while(map.containsKey(current)){
            result.append(current);
            result.append("->");
            result.append(map.get(current));
            result.append(", ");
            current = map.get(current);
        }
        result.delete(result.length()-2, result.length());
        return result.toString();
    }
}
