package com.educative.grokking.cyclicsort;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] {0,1,2,4}));
        //{0,2,1,4}
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr[arr.length-1];
        int i = 0;
        while(i<arr.length){
            //check if the number is not in correct index
            if(arr[i] != i && arr[i]<arr.length){
                //swap the number with the number in its correct position
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }
        for(int j=0; j< arr.length;j++){
            if(arr[j]!=j){
                return j;
            }
        }
        return 0;
    }
}
