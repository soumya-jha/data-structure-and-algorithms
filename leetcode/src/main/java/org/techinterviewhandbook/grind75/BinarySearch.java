package org.techinterviewhandbook.grind75;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);

    }

    private int binarySearch(int start, int end, int target, int[] nums) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target < nums[mid]) {
            return binarySearch(start, mid - 1, target, nums);
        } else {
            return binarySearch(mid + 1, end, target, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
