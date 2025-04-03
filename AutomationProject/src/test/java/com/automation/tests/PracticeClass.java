package com.automation.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PracticeClass {

	public static void main(String[] args) {
		
		 System.out.println(name());
		
		

	}
	public static int name() {
		
		int[] arr = {1,1,2};
		List<Integer> list = new ArrayList<>();
		 for(int i : arr) {
			 list.add(i);
		 }
		 List<Integer> li = list.stream().distinct().toList();
		 return li.size();
	}

}
