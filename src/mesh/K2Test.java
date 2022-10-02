package mesh;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class K2Test {
	@Test
	public void assertTrueTest() {
		String[] input1 = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
		String[] output1 = {"EMPTY", "group"};
		
		System.out.println("****** Solution Test ******");
		assertArrayEquals(output1,SolutionK2.solution(input1));
	}
}
