package toss;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
public class Toss5Test {
	@Test
	public void assertEqualsTest() {
		String expectedResult = "1";
		assertEquals(expectedResult, Toss5.solution(new String[] { "1" }));
	}

	@Test
	public void assertTrueTest() {
		String[] expectedResult = { "1" };
		System.out.println("****** Solution Test ******");
		assertTrue(Arrays.equals(expectedResult, Toss5.solution(new String[] { "1" })));
	}
}
