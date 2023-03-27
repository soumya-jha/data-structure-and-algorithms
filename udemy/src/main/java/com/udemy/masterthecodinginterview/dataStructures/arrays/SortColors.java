package com.udemy.masterthecodinginterview.dataStructures.arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
       // sc.sortColors(nums);
        sc.sortColors2(nums);
        //Output: [0,0,1,1,2,2]
    }

    public void sortColors(int[] nums) {
        //Two-pass solution
        int zeroCount = 0, oneCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else if (nums[i] == 1)
                oneCount++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount-- > 0)
                nums[i] = 0;
            else if (oneCount-- > 0)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }

    public void sortColors2(int[] nums) {
        //One-pass solution - incomplete
        int start = 0;
        int end = nums.length-1;
        //{2, 0, 2, 1, 1, 0};
        //{0, 2, 1, 0, 1, 2};

        //{0, 1, 1, 0, 0, 2};
        //{0, 1, 1, 0, 1, 2};
        //{0, 2, 1, 0, 0, 2};
        //{0, 2, 1, 0, 1, 2};
        while(start<end){
            if(nums[start]==0)
                start++;
            else if(nums[end]==2)
                end--;
            else{
                if(nums[start]>nums[end]){
                   int t=nums[start];
                   nums[start] = nums[end];
                   nums[end] = t;
                }
                end--;
            }
        }
    }
}
