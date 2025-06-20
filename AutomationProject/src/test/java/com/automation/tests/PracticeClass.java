package com.automation.tests;

import java.util.HashMap;
import java.util.Map;

public class PracticeClass {

	public static void main(String[] args) {	
		 System.out.println(convertStringToInt("1,000,000")); // Output: 1000000
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
	
	
	// Convert the string into integer by removing the commas
	// and then converting it to integer
	// Example: "1,000,000" -> 1000000
	// Don't use any built-in methods for conversion
	 public static int convertStringToInt(String str) {
		 
		 String cleanedStr = "";
		 for (char c : str.toCharArray()) {
			 if (c != ',') {
				 cleanedStr += c;
			 }
		 }
		 
		 return Integer.parseInt(cleanedStr);
	 }
	 
	 public String removeVowels(String str) {
		 StringBuilder sb = new StringBuilder();
		 String vowels = "aeiouAEIOU";
		 for(char ch : str.toCharArray()) {
			 if(vowels.indexOf(ch) == -1) {
				 sb.append(ch);
			 }
		 }
		 return sb.toString();
		 
	 }

}
