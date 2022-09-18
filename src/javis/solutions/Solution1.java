package javis.solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1 {
	public static int[] solution(String[] students) {

        int currentStudentId = 0;
		int currentStudentScore = 10;
		int scoreBuf = 0;
		int failCount = 0;
		HashMap<Integer,Integer> mapIdScore = new HashMap<>();
		
		for(String student : students) {
			scoreBuf = 0;
			currentStudentId++;
			currentStudentScore = 10;
			failCount = 0;
			for(int i = 0; i < student.length(); i++) {
				switch(student.charAt(i)) {
				case 'A':
					currentStudentScore += 1;
					break;
				case 'L':
					scoreBuf += 1;
					if(scoreBuf % 2 == 0) {
						scoreBuf = 0;
						currentStudentScore -= 1;
						failCount++;
					}
					break;
				case 'P':
					currentStudentScore -= 1;
					failCount++;
					break;
				default :
					break;
				}
				student.charAt(i);
			}
			if(failCount > 2) {
				currentStudentScore = 0;
			}
			mapIdScore.put(currentStudentId, currentStudentScore);
		}
		
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(mapIdScore.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
		    	return o2.getValue() - o1.getValue();
		    }
		});
		
		ArrayList<Integer> resultIdArray = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : entryList){
			resultIdArray.add(entry.getKey());
		}
		
		int[] answer = new int[resultIdArray.size()];
	    for(int i = 0; i < answer.length; i++){
	    	answer[i] = resultIdArray.get(i).intValue();
	    }

	    return answer;
	}
	
	
}
