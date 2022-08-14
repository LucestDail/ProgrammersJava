package toss2022.solutions;

import java.util.Collections;
import java.util.HashSet;

public class Solution1 {
	public static int solution(String input) {
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < input.length(); i++) {
			if(i > input.length() - 3) {
				continue;
			}
			String currentString = input.substring(i, i + 3);
			if(currentString.charAt(0) == currentString.charAt(1) && currentString.charAt(0) == currentString.charAt(2)) {
				hs.add(Integer.parseInt(currentString));
			}
		}
		int returnValue = 0;
		if(hs.isEmpty()) {
			return -1;
		}else {
			returnValue = Collections.max(hs);
		}
		return returnValue;
	}
	
	
}
