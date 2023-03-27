package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NewYearChaos {

	/*
	 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster
	 * ride! There are a number of people queued up, and each person wears a sticker
	 * indicating their initial position in the queue. Initial positions increment
	 * by 1 from 1 at the front of the line to n at the back.
	 * 
	 * Any person in the queue can bribe the person directly in front of them to
	 * swap positions. If two people swap positions, they still wear the same
	 * sticker denoting their original places in line. One person can bribe at most
	 * two others. For example, if n=8 and Person 5 bribes Person 4 , the queue will
	 * look like this: 1,2,3,5,4,6,7,8.
	 * 
	 * Fascinated by this chaotic queue, you decide you must know the minimum number
	 * of bribes that took place to get the queue into its current state!
	 * 
	 * Function Description
	 * 
	 * Complete the function minimumBribes in the editor below. It must print an
	 * integer representing the minimum number of bribes necessary, or Too chaotic
	 * if the line configuration is not possible.
	 * 
	 * minimumBribes has the following parameter(s):
	 * 
	 * q: an array of integers
	 * 
	 * Print an integer denoting the minimum number of bribes needed to get the
	 * queue into its final state. Print Too chaotic if the state is invalid, i.e.
	 * it requires a person to have bribed more than 2 people.
	 * 
	 */

	public static void main(String args[]) {
		//1 2 3 4 5
		//1 2 3 5 4
		//1 2 5 3 4
		//1 2 5 4 3
		int[] q = { 2, 1, 5, 4, 3 };
		minimumBribes(q);
	}

	static void minimumBribes(int[] q) {
		int minimumBribe = 0;
		boolean tooChaotic = false;
		List<Integer> queueList = Arrays.stream(q).boxed().collect(Collectors.toList());
		Collections.sort(queueList);
		ArrayList<Integer> skipList = new ArrayList<Integer>();
		for (int i = q.length - 1; i > 0; i--) {
			if (skipList.contains(i))
				continue;
			if (queueList.get(i) == q[i])
				continue;
			if (queueList.get(i) == q[i - 1]) {
				minimumBribe++;
				skipList.add(i - 1);
			} else if (i >= 2 && queueList.get(i) == q[i - 2]) {
				minimumBribe = minimumBribe + 2;
				skipList.add(i - 1);
				skipList.add(i - 2);
			} else {
				tooChaotic = true;
				break;
			}
		}
		if (tooChaotic)
			System.out.println("Too chaotic");
		else
			System.out.println(minimumBribe);
	}

}
