package toss2022.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toss2022.solutions.Solution7;

public class Test7 {
	@Test
	public void assertTrueTest() {
		
		Object input1 = null;
		Object input2 = null;
		Object input3 = null;
		Object input4 = null;
		Object input5 = null;
		
		Object output1 = null;
		Object output2 = null;
		Object output3 = null;
		Object output4 = null;
		Object output5 = null;
		
		
		System.out.println("****** Solution Test 1 ******");
		assertEquals(output1, Solution7.solution(input1));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(output2, Solution7.solution(input2));
		
		System.out.println("****** Solution Test 3 ******");
		assertEquals(output3, Solution7.solution(input3));
		
		System.out.println("****** Solution Test 4 ******");
		assertEquals(output4, Solution7.solution(input4));
		
		System.out.println("****** Solution Test 5 ******");
		assertEquals(output5, Solution7.solution(input5));

	}
}
