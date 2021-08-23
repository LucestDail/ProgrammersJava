package toss;

import java.util.*;

public class Toss6 {
	public long solution(int numOfStairs) {
		int[] targetArray = new int[70];
		targetArray[1] = 1;
		targetArray[2] = 2;
		targetArray[3] = 4;
        targetArray[4] = 7;
		for(int i = 4; i < numOfStairs; i++) {
			targetArray[i] = targetArray[i-1] + targetArray[i-2] + targetArray[i-3];
		}
		long answer = targetArray[numOfStairs];
		return answer;
	}

}
