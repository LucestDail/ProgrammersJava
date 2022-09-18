package javis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import javis.solutions.Solution1;

public class Test1 {
	@Test
	public void assertTrueTest() {
		
		String[] input1 = {"AAALLLAPAA", "AAAAAAAPPP", "ALAAAAPAAA"};
		String[] input2 = {"ALALLAAPAA", "ALLLAAAPAA", "APAPALLAAA"};
		
		int[] output1 = {3, 1, 2};
		int[] output2 = {1, 2, 3};
		
		
		System.out.println("****** Solution Test 1 ******");
		System.out.println(input1);
		System.out.println(output1);
		assertTrue(Arrays.equals(output1, Solution1.solution(input1)));
		
		System.out.println("****** Solution Test 2 ******");
		System.out.println(input2);
		System.out.println(output2);
		assertTrue(Arrays.equals(output2, Solution1.solution(input2)));
	}
}
