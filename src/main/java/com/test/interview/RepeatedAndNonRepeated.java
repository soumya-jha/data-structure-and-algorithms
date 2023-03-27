package com.test.interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RepeatedAndNonRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inpStr = "JAVACONCEPTOFTHEDAY"; //J is first non repeated char, A is first repeated char
		boolean foundR = false;
		boolean foundNR = false;
		char[] arr = inpStr.toCharArray();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for(char ch : arr) {
			String c = String.valueOf(ch);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				map.put(c, map.get(c)+1);
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			if(map.get(key) == 1 && !foundNR) {
				foundNR=true;
				System.out.println("First Non repeated char : " + key);
			}
			if(map.get(key) > 1 && !foundR) {
				foundR=true;
				System.out.println("First Repeated char : " + key);
			}
		}
	}

}
