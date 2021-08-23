package toss;

public class Toss4 {
	public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input.substring(0, 3));
        int dayCount = Integer.parseInt(input.substring(2,1));
		input = input.substring(3);
		System.out.println("input = " + input);
		
		
		
		while(input.length() > 0) {
			String targetKeyword = input.substring(0,5);
			System.out.println("target -> " + targetKeyword);
			if(targetKeyword.contains("SHOW")) {
				input = input.substring(3);
				sb.append("1");
				System.out.println("SHOW");
			}else if(targetKeyword.contains("NEGA")) {
				String targetKeywordDeep = input.substring(0,9);
				if(targetKeyword.contains("NEGATIVE"));
				input = input.substring(8);
				sb.append("0");
				System.out.println("NEGATIVE");
			}else if(targetKeyword.contains("NEXT")) {
				input = input.substring(3);
				sb.append("-");
				System.out.println("NEXT");
			}else if(targetKeyword.contains("EXIT")) {
				input = input.substring(3);
				sb.append("BYE");
				System.out.println("EXIT");
			}else {
				
			}
			
		}
		String answer = sb.toString();
        System.out.println("answer : " + answer);
        return answer;
    }
}
