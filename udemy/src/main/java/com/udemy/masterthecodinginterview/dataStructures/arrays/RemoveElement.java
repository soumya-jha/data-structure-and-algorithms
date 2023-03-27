package com.udemy.masterthecodinginterview.dataStructures.arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {};  // 2,2,2,_,_,_
        int val = 3;
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int left=0, right =nums.length-1;
        while(left<right){
            if(nums[right]==val){
                right--;
            }else if(nums[left] == val){
                nums[left] = nums[right];
                nums[right] = val;
                left++;right--;
            }else{
                left++;
            }
        }
        return (nums[left]==val?left:left+1);
    }
}
