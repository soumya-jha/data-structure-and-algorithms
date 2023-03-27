package com.educative.grokking.mergeintervals;


import com.educative.grokking.helper.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTimes {

    public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule) {
        List<Interval> combinedSchedule = new ArrayList<Interval>();
        for (ArrayList<Interval> list : schedule) {
            if (list != null)
                combinedSchedule.addAll(list);
        }
        Collections.sort(combinedSchedule, Comparator.comparing(Interval::getStart));
        List<Interval> ans = new ArrayList<Interval>();
        int end = combinedSchedule.get(0).getEnd();

        for (int i = 1; i < combinedSchedule.size(); i++) {
            int start = combinedSchedule.get(i).getStart();
            if (end < start) {
                ans.add(new Interval(end, start));
            }
            end = Math.max(end, combinedSchedule.get(i).getEnd());
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1, 2));
        list1.add(new Interval(5, 6));
        ArrayList<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(1, 3));
        list2.add(new Interval(4, 10));
        ArrayList<ArrayList<Interval>> finalList = new ArrayList<>();
        finalList.add(list1);
        finalList.add(list2);
        List<Interval> intervalList = employeeFreeTime(finalList);
        intervalList.stream().forEach(interval -> {
            System.out.println(interval.getStart() + "," + interval.getEnd());
        });

    }

}
