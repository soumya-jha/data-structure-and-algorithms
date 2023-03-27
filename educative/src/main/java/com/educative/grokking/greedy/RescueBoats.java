package com.educative.grokking.greedy;

import java.util.Arrays;

public class RescueBoats {
    public static void main(String[] args) {
        System.out.println(rescueBoats(new int[] {3,1,4,2,4}, 4));
    }

    public static int rescueBoats(int[] people, int limit) {
        Arrays.sort(people); //Sort the array
        //{1,2,3,4,4}
        int lightest = 0;
        int heaviest = people.length-1;
        int boatCount = 0;
        //Use two pointer approach
        while(lightest<=heaviest){
            if(people[heaviest] == limit || (people[heaviest]+people[lightest])>limit){
                heaviest--;
            } else if ((people[heaviest]+people[lightest])<=limit) {
                heaviest--;
                lightest++;
            }else{
                lightest++;
            }
            boatCount++;
        }
        return boatCount;
    }
}
