package toss;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
public class Toss2Test {
	@Test
	public void assertEqualsTest() {
		String expectedResult = "1";
		assertEquals(expectedResult, Toss2.solution(new String[] { "1" }));
	}

	@Test
	public void assertTrueTest() {
		String[] expectedResult = { "1" };
		System.out.println("****** Solution Test ******");
		assertTrue(Arrays.equals(expectedResult, Toss2.solution(new String[] { "1" })));
	}
}
