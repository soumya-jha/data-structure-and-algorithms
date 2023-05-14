package com.leetcode.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LosersOfCircularGame {
    public int[] circularGameLosers(int n, int k) {
        if (n == 1) {
            return new int[0];
        }
        int pos = 1;
        Set<Integer> winners = new HashSet<>();
        winners.add(1);
        for (int i = 1; ; i++) {
            pos += k * i;
            if (pos > n) {
                pos = pos % n;
            }
            if(pos==0){
                pos=n;
            }
            if (!winners.add(pos)) {
                break;
            }
        }
        if(winners.size()==n){
            return new int[0];
        }
        int[] losers = new int[n - winners.size()];
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            if (!winners.contains(i)) {
                losers[idx++] = i;
            }
        }
        return losers;
    }

    public static void main(String[] args) {
        LosersOfCircularGame lg = new LosersOfCircularGame();
        Arrays.stream(lg.circularGameLosers(5, 2)).forEach(i-> System.out.print(i+","));
        System.out.println();
        Arrays.stream(lg.circularGameLosers(4, 4)).forEach(i-> System.out.print(i+","));
        System.out.println();
        Arrays.stream(lg.circularGameLosers(2, 1)).forEach(i-> System.out.print(i+","));
        System.out.println();
        Arrays.stream(lg.circularGameLosers(5, 3)).forEach(i-> System.out.print(i+","));
    }
}
