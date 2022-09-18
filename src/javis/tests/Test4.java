package javis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import javis.solutions.Solution3;
import javis.solutions.Solution4;

public class Test4 {
	@Test
	public void assertTrueTest() {
		
		int[][] input1 = {{1, 4}, {2, 2}, {1, 3}, {1, 6}, {3, -1}, {2, -1}};
		int[][] input2 = {{1, 3}, {1, 2}, {3, 6}, {3, -1}, {4, 5}, {2, -1}, {3, -1}, {1, -1}};
		int[][] input3 = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}};
		
		int n1 = 3;
		int n2 = 4;
		int n3 = 5;
		
		int[] output1 = {4, 2};
		int[] output2 = {6, 3, 5, 2};
		int[] output3 = {6, 3, 5, 2};
		
		
		System.out.println("****** Solution Test 1 ******");
		assertTrue(Arrays.equals(output1, Solution4.solution(n1, input1)));
		
		System.out.println("****** Solution Test 2 ******");
		assertTrue(Arrays.equals(output2, Solution4.solution(n2, input2)));
		
		System.out.println("****** Solution Test 3 ******");
		assertTrue(Arrays.equals(output3, Solution4.solution(n3, input3)));
	}
}
