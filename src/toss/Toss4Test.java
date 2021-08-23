package toss;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
public class Toss4Test {
	@Test
	public void assertTrueTest() {
		String request1 = "1 2SHOWSHOWNEXTSHOWNEXTSHOWNEXTSHOWEXIT";
		String request2 = "2 2SHOWSHOWNEXTSHOWNEXTSHOWNEXTSHOWEXIT";
		String request3 = "2 3SHOWSHOWNEXTSHOWSHOWNEXTSHOWNEXTSHOWSHOWNEXTSHOWEXIT";
		String request4 = "2 3SHOWNEGATIVESHOWNEXTSHOWSHOWNEXTSHOWNEXTSHOWSHOWNEXTSHOWSHOWEXIT";
		String request5 = "1 3SHOWHELLOEXIT";
		
		String response1 = "1 211-0-1-1BYE";
		String response2 = "2 211-0-0-1BYE";
		String response3 = "2 311-10-0-00-1BYE";
		String response4 = "2 3100-00-0-11-10BYE";
		String response5 = "1 31ERRORBYE";

		
		System.out.println("****** Solution Test ******");
		assertTrue(response1.equals(Toss4.solution(request1)));
		assertTrue(response2.equals(Toss4.solution(request2)));
		assertTrue(response3.equals(Toss4.solution(request3)));
		assertTrue(response4.equals(Toss4.solution(request4)));
		assertTrue(response5.equals(Toss4.solution(request5)));
	}
}
