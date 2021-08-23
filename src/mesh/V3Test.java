package mesh;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class V3Test {
	@Test
	public void assertTrueTest() {
		String[] infos1 = { "kim password", "lee abc" };
		String[] infos2 = { "kim password", "lee abc" };

		String[] action1 = { "ADD 30", "LOGIN kim abc", "LOGIN lee password", "LOGIN kim password",
				"LOGIN kim password", "LOGIN lee abc", "ADD 30", "ORDER", "ORDER", "ADD 40", "ADD 50" };
		String[] action2 = { "LOGIN lee abc", "LOGIN kim password" };

		boolean[] return1 = { false, false, false, true, false, false, true, true, false, true, true };
		boolean[] return2 = { true, false };

		System.out.println("****** Solution Test ******");
		assertArrayEquals(return1, V3.solution(infos1, action1));
		assertArrayEquals(return2, V3.solution(infos2, action2));
	}
}
