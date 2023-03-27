package com.educative.grokking.greedy;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[] {3, 2, 2, 0, 1, 4}));
    }

    public static boolean jumpGame(int[] nums) {
        int targetIdx = nums.length-1;
        for(int i= nums.length-2; i>=0; i--){
            if(nums[i] + i >= targetIdx){
                targetIdx=i;
            }
        }
        return targetIdx==0 ? true : false;
    }

}
