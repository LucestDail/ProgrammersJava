package toss;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class Toss6Test {
	/*
	@Test
	public void assertEqualsTest() {
		String expectedResult = "1";
		assertEquals(expectedResult, Toss1.solution(new String[] { "1" }));
	}
	*/
	@Test
	public void assertTrueTest() {
		int[][] requestParameter1 = {{1,4},{3,4},{3,10}};
		int[][] requestParameter2 = {{1,1},{2,2},{1,2}};
		int[] expectedResult1 = {1,10};
		int[] expectedResult2 = {2,1};
		System.out.println("****** Solution Test ******");
		assertTrue(Arrays.equals(expectedResult1, Toss1.solution(requestParameter1)));
		assertTrue(Arrays.equals(expectedResult2, Toss1.solution(requestParameter2)));
	}
}
