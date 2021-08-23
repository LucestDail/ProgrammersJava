package toss;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class Toss1Test {
	/*
	@Test
	public void assertEqualsTest() {
		String expectedResult = "1";
		assertEquals(expectedResult, Toss1.solution(new String[] { "1" }));
	}
	*/
	@Test
	public void assertTrueTest() {
		long orderAmount1 = 100L;
		long orderAmount2 = 120L;
		long orderAmount3 = 120L;
		
		long taxFreeAmount1 = 0;
		long taxFreeAmount2 = 20;
		long taxFreeAmount3 = 0;
		
		long serviceFee1 = 0;
		long serviceFee2 = 0;
		long serviceFee3 = 20;
		
		long answer1 = 10;
		long answer2 = 10;
		long answer3 = 10;
		
		System.out.println("****** Solution Test ******");
		assertEquals(answer1, Toss1.solution(orderAmount1,taxFreeAmount1, serviceFee1));
		assertEquals(answer2, Toss1.solution(orderAmount2,taxFreeAmount2, serviceFee2));
		assertEquals(answer3, Toss1.solution(orderAmount3,taxFreeAmount3, serviceFee3));
	}
}
