package com.automation.tests;

import java.util.HashMap;
import java.util.Map;

public class PracticeClass {

	public static void main(String[] args) {	
		 System.out.println(name());
	}
	public static int name() {
		
		char[] chars = {'a','d','c'};
		Map<Character,Integer> value = new HashMap<>();
		for(char c: chars) {
			value.put(c,value.getOrDefault(c, 0)+1);
		}
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character,Integer> entry: value.entrySet()) {
			sb.append(entry.getValue());
			sb.append(entry.getKey());
			
		}
		String str = sb.toString();
		chars = str.toCharArray();
		System.out.println(chars);
		return chars.length;
	}

}
