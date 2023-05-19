package com.leetcode.random;

import java.util.*;

class Pair {
    private final String name;
    private final int height;

    Pair(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}

public class SortThePeople {
    public static String[] sortName(String[] names, int[] heights) {
        String[] result = new String[names.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], i);
        }
        Arrays.sort(heights);
        int idx = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[idx++] = names[map.get(heights[i])];
        }
        return result;
    }

    public static String[] sortNameUsingPair(String[] names, int[] heights) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            pairs.add(new Pair(names[i], heights[i]));
        }
        return pairs.stream()
                .sorted(Comparator.comparing(Pair::getHeight).reversed())
                .map(Pair::getName).toArray(String[]::new);
    }

    public static void main(String[] args) {
        Arrays.stream(
                sortName(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(
                sortName(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(
                sortNameUsingPair(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(
                sortNameUsingPair(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(
                sortNameUsingPair(new String[]{"Mary", "John", "Emma", "Elle"}, new int[]{180, 165, 170, 165})).forEach(System.out::println);
    }
}
