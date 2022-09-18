package javis.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import javis.solutions.Solution2;
import javis.solutions.Solution3;

public class Test3 {
	@Test
	public void assertTrueTest() {
		
		String[] board1 = {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
		String[] board2 = {"MME", "EEE", "EME"};
		
		int x1 = 0;
		int x2 = 0;
		
		int y1 = 2;
		int y2 = 0;
		
		String[] return1 = {"B1E1B", "B1E1B", "B111B", "BBBBB"};
		String[] return2 = {"XME", "EEE", "EME"};
		
		System.out.println("****** Solution Test 1 ******");
		assertTrue(Arrays.equals(return1, Solution3.solution(board1, x1, y1)));
		
		System.out.println("****** Solution Test 2 ******");
		assertTrue(Arrays.equals(return1, Solution3.solution(board2, x2, y2)));
	}
}
