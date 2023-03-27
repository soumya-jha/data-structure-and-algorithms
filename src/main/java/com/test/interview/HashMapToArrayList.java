package com.test.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapToArrayList {

	public static void main(String[] args) {
		Map<String, String> studentPerformanceMap = new HashMap<String, String>();
		// Adding elements to HashMap
		studentPerformanceMap.put("John Kevin", "Average");
		studentPerformanceMap.put("Rakesh Sharma", "Good");
		studentPerformanceMap.put("Prachi D", "Very Good");
		studentPerformanceMap.put("Ivan Jose", "Very Bad");
		studentPerformanceMap.put("Smith Jacob", "Very Good");
		studentPerformanceMap.put("Anjali N", "Bad");
		
		Set<String> keySet = studentPerformanceMap.keySet();
		List<String> list = keySet.stream()
		.collect(Collectors.toList());
		
		System.out.println(list.toString());
		
		Collection<String> values = studentPerformanceMap.values();
		List<String> list1 = values.stream()
		.collect(Collectors.toList());
		System.out.println(list1);
		
		Set<Entry<String, String>> entrySet = studentPerformanceMap.entrySet();
		List<Entry<String, String>> list3 = entrySet.stream()
				.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
		.collect(Collectors.toList());
		
		System.out.println(list3);
		
		List<String> list5 = entrySet.stream()
				.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.map(Entry::getKey)
		.collect(Collectors.toList());
		
		System.out.println("list5 :: " + list5);
		
		//ArrayList to HashMap
		
		List<String> list4 = new ArrayList<String>();
		list4.add("My");
		list4.add("Name");
		list4.add("is");
		list4.add("Soumya");

		Map<String, Integer> testMap = list4.stream()
				.collect(Collectors.toMap(element -> element, element -> element.length()));
		System.out.println(testMap);
		
		
	}

}
