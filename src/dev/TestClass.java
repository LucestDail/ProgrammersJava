package dev;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestClass {
	
	@Test
	public void assertTrueTest() {
		
		String[] registerd_list1 = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
		String[] registerd_list2 = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
		String[] registerd_list3 = {"bird99", "bird98", "bird101", "gotoxy"};
		String[] registerd_list4 = {"apple1", "orange", "banana3"};
		
		String new_id1 = "ace15";
		String new_id2 = "cow";
		String new_id3 = "bird98";
		String new_id4 = "apple";
		
		String result1 = "ace15";
		String result2 = "cow";
		String result3 = "bird100";
		String result4 = "apple";
		
		System.out.println("****** Solution Test 1 ******");
		assertEquals(result1, Solution.solution(registerd_list1, new_id1));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(result2, Solution.solution(registerd_list2, new_id2));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(result3, Solution.solution(registerd_list3, new_id3));
		
		System.out.println("****** Solution Test 2 ******");
		assertEquals(result4, Solution.solution(registerd_list4, new_id4));
		
	}
}
