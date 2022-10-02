package javis.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javis.solutions.Solution7;

public class Test7 {
	@Test
	public void assertTrueTest() {
		
		String[] input1 = {"3", "3 2 1"};
		int output1 = 3;
		
		System.out.println("****** Solution Test 1 ******");
		assertEquals(output1, Solution7.solution(input1));
		
	}
}
