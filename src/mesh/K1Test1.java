package mesh;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toss.Toss1;

public class K1Test1 {
	@Test
	public void assertTrueTest() {
		String word1 = "APPLE";
		String word2 = "BAB";
		String word3 = "BABXZ";
		
		String[] cards1 = {"LLZKE", "LCXEA", "CVPPS", "EAVSR", "FXPFP"};
		String[] cards2 = {"ZZBZ", "BAZB", "XBXB", "XBAX"};
		String[] cards3 = {"ZZBZ", "BAZB", "XBXB", "XBAX"};
		
		
		System.out.println("****** Solution Test ******");
		assertEquals(3, V1.solution(word1, cards1));
		assertEquals(4, V1.solution(word2, cards2));
		assertEquals(0, V1.solution(word3, cards3));
	}
}
