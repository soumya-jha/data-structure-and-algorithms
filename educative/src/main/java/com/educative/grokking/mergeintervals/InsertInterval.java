package com.educative.grokking.mergeintervals;


import com.educative.grokking.helper.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> combinedSchedule = new ArrayList();
        ArrayList<Interval> list = new ArrayList<>();
            combinedSchedule.addAll(list);
        Collections.sort(combinedSchedule, Comparator.comparing(Interval::getStart));
    }

    public static List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        /* if size is zero, add new interval and return
         * if new interval is greater than last interval of existingIntervals,
         * add new interval and return
         */
        if (existingIntervals.size() == 0 ||
                (newInterval.getStart() > existingIntervals.get(existingIntervals.size() - 1).getStart()
                        && newInterval.getStart() > existingIntervals.get(existingIntervals.size() - 1).getEnd())) {
            existingIntervals.add(newInterval);
            return existingIntervals;
        }
        List<Interval> output = new ArrayList<>();
        boolean added = false;
        boolean doBalance = false;
        for (int i = 0; i < existingIntervals.size(); i++) {
            Interval currInterval = existingIntervals.get(i);
            if (added) {
                if (!doBalance) {
                    output.add(currInterval);
                } else {
                    Interval lastAdded = output.get(output.size() - 1);
                    if (lastAdded.getEnd() >= currInterval.getStart()) {
                        output.get(output.size() - 1).setEnd(Math.max(lastAdded.getEnd(), currInterval.getEnd()));
                    } else {
                        doBalance = false;
                        output.add(currInterval);
                    }
                }
            } else {
                if (newInterval.getStart() > currInterval.getStart()
                        && newInterval.getStart() > currInterval.getEnd()) {
                    output.add(currInterval);
                } else if (newInterval.getStart() > currInterval.getStart()
                        && newInterval.getStart() <= currInterval.getEnd()) {
                    Interval addInterval = new Interval(currInterval.getStart(), Math.max(currInterval.getEnd(), newInterval.getEnd()));
                    output.add(addInterval);
                    added = true;
                    doBalance = true; //balance remaining intervals from input list
                } else if (newInterval.getStart() < currInterval.getStart()
                        && newInterval.getEnd() < currInterval.getStart()) {
                    output.add(newInterval);
                    added = true;
                    i--;
                } else if (newInterval.getStart() < currInterval.getStart()
                        && newInterval.getEnd() >= currInterval.getStart()) {
                    Interval addInterval = new Interval(newInterval.getStart(), Math.max(currInterval.getEnd(), newInterval.getEnd()));
                    output.add(addInterval);
                    added = true;
                    doBalance = true; //balance remaining intervals from input list
                }
            }
        }
        return output;
    }

    public static List<Interval> insertInterval2(List<Interval> existingIntervals, Interval newInterval) {
        if (existingIntervals.size() == 0 ||
                (newInterval.getStart() > existingIntervals.get(existingIntervals.size() - 1).getStart()
                        && newInterval.getStart() > existingIntervals.get(existingIntervals.size() - 1).getEnd())) {
            existingIntervals.add(newInterval);
            return existingIntervals;
        }
        //Existing intervals: [[1, 2], [3, 8], [6, 8]]
        //New interval: [5, 7]
        //
        //New intervals list: [[1, 2], [3, 8]]

        List<Interval> output = new ArrayList<>();
        boolean added = false;
        boolean doBalance = false;
        int start = newInterval.getStart();
        int end = newInterval.getEnd();
        for(int i = 0; i<existingIntervals.size();i++){
            Interval currInterval = new Interval(existingIntervals.get(i).getStart(), existingIntervals.get(i).getEnd());
            if(added){
                if(currInterval.getEnd()>=start){
                    output.get(output.size()-1).setEnd(Math.max(end, currInterval.getEnd()));
                    added = true;
                }
            }
            if(start>=currInterval.getStart()){
                output.add(currInterval);
                if(currInterval.getEnd()>=start){
                    output.get(output.size()-1).setEnd(Math.max(end, currInterval.getEnd()));
                    added = true;
                }
            }else{
                    output.add(newInterval);
                    if(currInterval.getStart()<=output.get(output.size()-1).getEnd()){
                        output.get(output.size()-1).setEnd(Math.max(output.get(output.size()-1).getEnd(), currInterval.getEnd()));
                    }else {
                        output.add(currInterval);
                    }
            }
        }
        return output;
    }
}
