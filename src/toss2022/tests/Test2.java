package toss2022.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toss2022.solutions.Solution2;

public class Test2 {
	@Test
	public void assertTrueTest() {
		
		int[] input1 = {1, 2, 3, 4};
		int[] input2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int output1 = 4;
		int output2 = 8;
		
		
		System.out.println("****** Solution Test 1 ******");
		assertEquals(output1, Solution2.solution(input1));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(output2, Solution2.solution(input2));

	}
}
