package mesh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Grade {
	private int grade;
	private int gradeCounter;

	public Grade(int grade, int gradeCounter) {
		this.grade = grade;
		this.gradeCounter = gradeCounter;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGradeCounter() {
		return gradeCounter;
	}

	public void setGradeCounter(int gradeCounter) {
		this.gradeCounter = gradeCounter;
	}

	@Override
	public String toString() {
		return "Grade [grade=" + grade + ", gradeCounter=" + gradeCounter + "]";
	}

}

public class V2 {

	public static String[] solution(String[] grades) {
		int putCounter = 0;
		Map<String, Grade> scoreGrade = new LinkedHashMap<>();
		for (int i = 0; i < grades.length; i++) {
			String gNum = grades[i].split(" ")[0];
			String gGrade = grades[i].split(" ")[1];
			if (scoreGrade.containsKey(gNum)) {
				if (scoreGrade.get(gNum).getGrade() < returnScore(gGrade)) {
					scoreGrade.put(gNum, new Grade(returnScore(gGrade), putCounter++));
				} else {
					continue;
				}
			} else {
				scoreGrade.put(gNum, new Grade(returnScore(gGrade), putCounter++));
			}
		}

		List<Entry<String, Grade>> gradeEntryList = new LinkedList<>(scoreGrade.entrySet());
		gradeEntryList.sort(new Comparator<Map.Entry<String, Grade>>() {
			@Override
			public int compare(Map.Entry<String, Grade> o1, Map.Entry<String, Grade> o2) {
				if(o1.getValue().getGrade() == o2.getValue().getGrade()) {
					return o1.getValue().getGradeCounter() - o2.getValue().getGradeCounter();
				}
				return o2.getValue().getGrade() - o1.getValue().getGrade();
			}
		});
		List<String> returnAnswer = new ArrayList<>();
		for (Entry<String, Grade> e : gradeEntryList) {
			returnAnswer.add(e.getKey() + " " + returnGrade(e.getValue().getGrade()));
		}
		
		String[] answer = new String[returnAnswer.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = returnAnswer.get(i);
		}
		return answer;
	}

	public static int returnScore(String gGrade) {
		int returnValue = 0;
		switch (gGrade) {
		case "A+":
			returnValue = 13;
			break;
		case "A0":
			returnValue = 12;
			break;
		case "A-":
			returnValue = 11;
			break;
		case "B+":
			returnValue = 10;
			break;
		case "B0":
			returnValue = 9;
			break;
		case "B-":
			returnValue = 8;
			break;
		case "C+":
			returnValue = 7;
			break;
		case "C0":
			returnValue = 6;
			break;
		case "C-":
			returnValue = 5;
			break;
		case "D+":
			returnValue = 4;
			break;
		case "D0":
			returnValue = 3;
			break;
		case "D-":
			returnValue = 2;
			break;
		case "F":
			returnValue = 1;
			break;
		}
		return returnValue;
	}

	public static String returnGrade(int score) {
		String returnGrade = null;
		switch (score) {
		case 13:
			returnGrade = "A+";
			break;
		case 12:
			returnGrade = "A0";
			break;
		case 11:
			returnGrade = "A-";
			break;
		case 10:
			returnGrade = "B+";
			break;
		case 9:
			returnGrade = "B0";
			break;
		case 8:
			returnGrade = "B-";
			break;
		case 7:
			returnGrade = "C+";
			break;
		case 6:
			returnGrade = "C0";
			break;
		case 5:
			returnGrade = "C-";
			break;
		case 4:
			returnGrade = "D+";
			break;
		case 3:
			returnGrade = "D0";
			break;
		case 2:
			returnGrade = "D-";
			break;
		case 1:
			returnGrade = "F";
			break;
		}
		return returnGrade;
	}
}
