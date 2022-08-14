package toss2022.solutions;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Solution2 {
	public static int solution(int[] levels) {
		
		System.out.println(levels.length);
		int q1Percentage = Math.round(((levels.length + 1)/4 * 1));
		int q2Percentage = Math.round(((levels.length + 1)/4 * 2));
		int q3Percentage = Math.round(((levels.length + 1)/4 * 3));
		int q4Percentage = Math.round(((levels.length + 1)/4 * 4));

		System.out.println(q1Percentage);
		System.out.println(q2Percentage);
		System.out.println(q3Percentage);
		System.out.println(q4Percentage);
		
		int[] q1 = Arrays.copyOfRange(levels, 0, q1Percentage);
		int[] q2 = Arrays.copyOfRange(levels, q1Percentage, q2Percentage);
		int[] q3 = Arrays.copyOfRange(levels, q2Percentage, q3Percentage);
		int[] q4 = Arrays.copyOfRange(levels, q3Percentage, q4Percentage);
		
		System.out.println(Arrays.toString(q1));
		System.out.println(Arrays.toString(q2));
		System.out.println(Arrays.toString(q3));
		System.out.println(Arrays.toString(q4));
		
		List<int[]> listArray = Arrays.asList(q4);
		int answer = listArray.get(0)[0];
        return answer;
    }
}
