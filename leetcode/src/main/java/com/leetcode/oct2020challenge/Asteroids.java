package com.leetcode.oct2020challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Asteroids {

	public static void main(String[] args) {

		// int[] asteroids = { 5, 10, -5 };
		// int[] asteroids = {8,-8};
		// int[] asteroids = { 10, 2, -5 };
		// int[] asteroids = {-2,-1,1,2};
		// int[] asteroids = {1, 8,-8, -2};
		// int[] asteroids = {-2,-2,1,-1};
		// int[] asteroids = { -2, 1, -1, -2 };
		int[] asteroids = { -2, 2, -1, -2 };

		Asteroids asteroidsObj = new Asteroids();
		int[] returnAsteroids = asteroidsObj.asteroidCollision(asteroids);
		System.out.println("Asteroids : " + Arrays.toString(returnAsteroids));
		returnAsteroids = asteroidsObj.asteroidCollisionUsingDequeue(asteroids);
		System.out.println("Asteroids using Deque: " + Arrays.toString(returnAsteroids));
	}

	public int[] asteroidCollision(int[] asteroids) {
		ArrayList<Integer> astList = IntStream.of(asteroids).boxed().collect(Collectors.toCollection(ArrayList::new));
		for (int i = astList.size() - 1; i > 0;) {
			if (astList.get(i) < 0 && astList.get(i - 1) > 0) {
				if (Math.abs(astList.get(i)) < astList.get(i - 1)) {
					astList.remove(i);
				} else if (Math.abs(astList.get(i)) > astList.get(i - 1)) {
					astList.remove(i - 1);
				} else {
					astList.remove(i);
					astList.remove(i - 1);
				}
				i = astList.size() - 1;
			} else {
				i--;
			}
		}
		return astList.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] asteroidCollisionUsingDequeue(int[] asteroids) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int asteroid : asteroids) {
			explode: {
				while (!deque.isEmpty() && deque.peekLast() > 0 && asteroid < 0) {
					if (deque.peekLast() < -asteroid) {
						deque.pollLast();
					} else if (deque.peekLast() == -asteroid) {
						deque.pollLast();
						break explode;
					} else {
						break explode;
					}
				}
				deque.offerLast(asteroid);
			}
		}
		return deque.stream().mapToInt(Integer::intValue).toArray();
	}
}
