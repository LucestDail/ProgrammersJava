package javis.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import javis.solutions.Solution2;

public class Test2 {
	@Test
	public void assertTrueTest() {
		
		int[][] input1 = {{2, 3, 4, 0, 1}, {1, 4, 3, 2, 0}, {4, 1, 0, 2, 3}, {3, 2, 1, 4, 0}, {0, 3, 2, 1, 4}};
		int[][] input2 = {{2, 1, 0, 3}, {3, 2, 0, 1}, {3, 0, 2, 1}, {2, 3, 0, 1}};
		
		int[] output1 = {4,3};
		int[] output2 = {1,3};
		
		
		System.out.println("****** Solution Test 1 ******");
		assertTrue(Arrays.equals(output1, Solution2.solution(input1)));
		
		System.out.println("****** Solution Test 2 ******");
		assertTrue(Arrays.equals(output2, Solution2.solution(input2)));

	}
}
