package mesh;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class V2Test {
	@Test
	public void assertTrueTest() {
		String[] grades1 = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
		String[] grades2 = {"DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"};
		
		String[] return1 = {"DS7651 A+", "OS1808 B-", "DB0001 B-", "AI5543 C0", "CA0055 D+", "AI0001 F"};
		String[] return2 = {"GP0000 A0", "PL6677 B+", "DM0106 B+"};
		
		System.out.println("****** Solution Test ******");
		assertArrayEquals(return1, V2.solution(grades1));
		assertArrayEquals(return2, V2.solution(grades2));
	}
}
