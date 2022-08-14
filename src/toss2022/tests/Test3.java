package toss2022.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toss2022.solutions.Solution3;

public class Test3 {
	@Test
	public void assertTrueTest() {
		
		int[][] input1 = {{80, 20}, {50, 40}, {30, 10}};
		int[][] input2 = {{700, 266}, {111, 78}, {871, 655}};
		int[][] input3 = {{285, 264}, {36, 1}, {549, 293}, {221, 11}, {83, 59}, {894, 838}, {190, 176}};
		
		int input1a = 80;
		int input2a = 966;
		int input3a = 349;
		
		Object output1 = 3;
		Object output2 = 2;
		Object output3 = 4;
		
		
		System.out.println("****** Solution Test 1 ******");
		assertEquals(output1, Solution3.solution(input1a, input1));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(output2, Solution3.solution(input2a, input2));
		
		System.out.println("****** Solution Test 3 ******");
		assertEquals(output3, Solution3.solution(input3a, input3));

	}
}
