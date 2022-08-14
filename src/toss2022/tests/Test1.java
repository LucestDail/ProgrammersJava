package toss2022.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toss2022.solutions.Solution1;

public class Test1 {
	@Test
	public void assertTrueTest() {
		
		String input1 = "12223";
		String input2 = "111999333";
		String input3 = "123";
		
		int output1 = Integer.parseInt("222");
		int output2 = Integer.parseInt("999");
		int output3 = Integer.parseInt("-1");
		
		
		System.out.println("****** Solution Test 1 ******");
		assertEquals(output1, Solution1.solution(input1));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(output2, Solution1.solution(input2));
		
		System.out.println("****** Solution Test 3 ******");
		assertEquals(output3, Solution1.solution(input3));

	}
}
