package org.geeksforgeeks;

/*Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9 
 * Example
 * Input:
N = 9
Output:
10
Explanation:
After removing natural numbers which contains
digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
and 9th number is 10.
*/
public class NthNaturalNumber {

	public static void main(String[] args) {
		System.out.println(findNth(20));

	}

	public static int findNth(int n) {
		if (n < 9) {
			return n;
		} else {
			int count = 0;
			int naturalNum = 1;
			while (count < n) {
				count+=contains9(naturalNum);
				naturalNum++;
			}
			return naturalNum-1;
		}
	}
	
	public static int contains9(int n) {
		while(n>0) {
			if(n%10==9) {
				return 0;
			}else {
				n=n/10;
			}
		}
		return 1;
	}

}
