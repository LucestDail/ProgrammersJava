package toss;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
public class Toss3Test {
	@Test
	public void assertTrueTest() {
		String request1 = "10000";
		String request2 = "25,000";
		String request3 = "39,00";
		String request4 = "1¸¸¿ø";
		String request5 = "10,000¿ø";
		String request6 = "+300";
		String request7 = "0100";
		String request8 = "39900";
		String request9 = "25,000,123";
		String request10 = "24,999,99";
		String request11 = ",999,000";
		String request12 = "10,000,";
		
		boolean response1 = true;
		boolean response2 = true;
		boolean response3 = false;
		System.out.println("****** Solution Test ******");
		assertTrue(response1 == Toss3.solution(request1));
		assertTrue(response2 == Toss3.solution(request2));
		assertTrue(response3 == Toss3.solution(request3));
		assertTrue(response3 == Toss3.solution(request4));
		assertTrue(response3 == Toss3.solution(request5));
		assertTrue(response3 == Toss3.solution(request6));
		assertTrue(response3 == Toss3.solution(request7));
		assertTrue(response2 == Toss3.solution(request8));
		assertTrue(response2 == Toss3.solution(request9));
		assertTrue(response3 == Toss3.solution(request10));
		assertTrue(response3 == Toss3.solution(request11));
		assertTrue(response3 == Toss3.solution(request12));
	}
}
