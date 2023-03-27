package com.educative.grokking.topKelements;


import com.educative.grokking.helper.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPoints {
    public static void main(String[] args) {

    }
    public static List<Point> kClosest(Point[] points, int k) {
        List<Point> result = new ArrayList<>();
        Comparator<Point> distComparator = Comparator.comparing(point -> Math.sqrt((Math.pow(point.x, 2)) + (Math.pow(point.y, 2))));
        PriorityQueue<Point> minHeap = new PriorityQueue<>(distComparator);
        for(Point p : points) {
            minHeap.add(p);
        }
        int count = 0;
        while(!minHeap.isEmpty() && count<k) {
            Point p = minHeap.poll();
            result.add(p);
            count++;
        }
        return result;
    }
}
