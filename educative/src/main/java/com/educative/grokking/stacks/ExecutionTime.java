package com.educative.grokking.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//INCOMPLETE
class Event {
    int id;
    boolean isStart;
    int time;

    public Event(int id, int time, boolean isStart){
        this.id = id;
        this.time = time;
        this.isStart = isStart;
    }
}

public class ExecutionTime {
    public static void main(String[] args) {
        List<String> events = new ArrayList<>();
        events.add("0:start:0");
        events.add("0:end:0");
        events.add("1:start:1");
        events.add("1:end:1");
        events.add("2:start:2");
        events.add("2:end:2");
        events.add("2:start:3");
        events.add("2:end:3");
        System.out.println(exclusiveTime(3, events));
    }

    public static List<Integer> exclusiveTime(int n, List<String> events) {
        List<Integer> result = new ArrayList<>(n);
        for(int i=0; i<n;i++){
            result.add(0);
        }
        Stack<Event> stack = new Stack<>();
        for (String s : events) {
            Event event = new Event(Character.getNumericValue(s.charAt(0)), Character.getNumericValue(s.charAt(s.length()-1)), s.charAt(2)=='s'?true:false);
            if(event.isStart){
                stack.push(event);
            }else{
                Event popEvent = stack.pop();
                int excTime;
                if(popEvent.time<0){
                    excTime = event.time+popEvent.time+1;
                }
                excTime = event.time-popEvent.time+1;
                result.set(event.id, result.get(event.id)+excTime);
                if(!stack.isEmpty()){
                    Event update = stack.pop();
                    update.time -= excTime;
                    stack.push(update);
                }
            }
        }
        return result;
    }
}
