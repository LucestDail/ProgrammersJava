package toss;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class Toss1Test {
	@Test
	public void assertEqualsTest() {
		String expectedResult = "1";
		assertEquals(expectedResult, Toss1.solution(new String[] { "1" }));
	}

	@Test
	public void assertTrueTest() {
		String[] expectedResult = { "1" };
		System.out.println("****** Solution Test ******");
		assertTrue(Arrays.equals(expectedResult, Toss1.solution(new String[] { "1" })));
	}
}
