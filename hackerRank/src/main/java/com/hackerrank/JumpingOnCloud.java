package com.hackerrank;

/*Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.

For each game, Emma will get an array of clouds numbered  if they are safe or  if they must be avoided. For example,  indexed from . The number on each cloud is its index in the list so she must avoid the clouds at indexes  and . She could follow the following two paths:  or . The first path takes jumps while the second takes .

Function Description

Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.

jumpingOnClouds has the following parameter(s):

c: an array of binary integers
Input Format

The first line contains an integer , the total number of clouds. The second line contains  space-separated binary integers describing clouds  where .

Constraints

Output Format

Print the minimum number of jumps needed to win the game.

Sample Input

0 0 1 0 0 1 0
Sample Output

4*/

public class JumpingOnCloud {
	
	public static void main(String args[]) {
		int[] c = new int[]{0,0,0,1,0,0};
		int minJumps = jumpingOnClouds(c);
		System.out.println("Min Jumps : " + minJumps );
	}
	
	 static int jumpingOnClouds(int[] c) { 
		 int minJumps = 0;
		 boolean skip=false;
		 for(int i=0;i<c.length-1;i++) {
			 if(skip) {
				 skip=false;
				 continue;
			 }
			if(i+2<=c.length-1 && c[i+2] == 0) {
				skip=true;
				minJumps++;
			}else {
				minJumps++;
			}
		 }
		 return minJumps;
	 }

}
