package com.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;

public class SockMerchant {
	
	public static void main(String[] args) {
		
		int[] intArray = {10,20,20,10,10,30,50,10,20};
		int numOfPairs = sockMerchant1(9, intArray);
		System.out.println("Using two for-loops :: "+numOfPairs);
		numOfPairs = sockMerchant2(9, intArray);
		System.out.println("Using HashMap :: " +numOfPairs);
		
	}

	//Using two for-loops
	static int sockMerchant1(int n, int[] ar) {
		int numOfPairs = 0;
		int maxNumOfPairs = n/2;
		ArrayList<Integer> temp=new ArrayList<>();
		for(int i=0; i< n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if((temp==null || !temp.contains(i)) && ar[i]==ar[j]) {
					numOfPairs++;
					temp.add(j);
					break;
				}
				if(numOfPairs==maxNumOfPairs)
					break;
			}
			
		}
		return numOfPairs;

	}
	
	//Using HashMap
	static int sockMerchant2(int n, int[] ar) {
		int numOfPairs = 0;
		HashMap<Integer,Integer> tempMap = new HashMap<>();
		for(int i=0; i< n;i++) {
			if(!tempMap.containsKey(ar[i]))
				tempMap.put(ar[i], 1);
			else {
				tempMap.replace(ar[i], tempMap.get(ar[i])+1);
				if(tempMap.get(ar[i])%2==0)
					numOfPairs++;
			}
		}
		return numOfPairs;

	}

}
