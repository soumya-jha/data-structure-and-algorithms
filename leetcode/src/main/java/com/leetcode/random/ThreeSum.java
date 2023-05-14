package com.leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//incomplete
public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4}; //{-4, -1, -1, 0, 1, 2}
        List<List<Integer>> finalList = new ThreeSum().threeSum(nums);
        for (int i = 0; i < finalList.size(); i++) {
            for (int j = 0; j < finalList.get(i).size(); j++) {
                System.out.print("InnerList " + j + " :" + finalList.get(i).get(j));
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> negList = new ArrayList<>();
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negList.add(nums[i]);
            } else {
                posList.add(nums[i]);
            }
        }
        return finalList;
    }
}
