package com.ruby.java.ch10;

import java.util.HashMap;

public class Test06 {

	public static void main(String[] args) {

		String word[] = {"Bumblebee", "Heaven", "Although", "Wonder"};
		String meaning[] = {"꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다"};
		
		HashMap<String, String> dic = new HashMap<String, String>();
		
		for(int i = 0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		
		dic.put("고건", "학생");

		
		System.out.println(dic);
		System.out.println(dic.size());
		
		System.out.println(dic.keySet());
		System.out.println(dic.values());

	}

}
