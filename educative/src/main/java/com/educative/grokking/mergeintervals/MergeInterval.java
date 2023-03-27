package com.educative.grokking.mergeintervals;


import com.educative.grokking.helper.Interval;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {

        List<Interval> l = new ArrayList<>();
        Interval i1 = new Interval(1, 5);
        Interval i2 = new Interval(3, 7);
        Interval i3 = new Interval(4, 6);
        l.add(i1);
        l.add(i2);
        l.add(i3);
        mergeIntervals(l).forEach(i->{
            System.out.println(i.getStart() + "," + i.getEnd());
        });
    }

    public static List<Interval> mergeIntervals(List<Interval> l) {
        List<Interval> resultList = new ArrayList<>();
        resultList.add(l.get(0));
        for (int i = 1; i < l.size(); i++) {
            int size = resultList.size();
            if (l.get(i).getStart() <= resultList.get(size - 1).getEnd()) {
                resultList.get(size - 1).setEnd(Math.max(l.get(i).getEnd(), resultList.get(size - 1).getEnd()));
            } else {
                resultList.add(l.get(i));
            }
        }
        return resultList;
    }
}
