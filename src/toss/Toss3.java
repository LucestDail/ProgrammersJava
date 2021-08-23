package toss;

public class Toss3 {
	public static boolean solution(String amountText) {
		// check condition 1
		for (int i = 0; i < amountText.length(); i++) {
			if ((amountText.charAt(i) > 47 && amountText.charAt(i) < 58) || amountText.charAt(i) == 44) {
				continue;
			} else {
				//System.out.println(amountText + " has been cut in step 1");
				return false;
			}
		}
		// check condition 2
		if (amountText.substring(0, 1).equals("0")) {
			//System.out.println(amountText + " has been cut in step 2");
			return false;
		}

		// check condition 3
		if (amountText.contains(",")) {
			int comma = 0;
			for (int i = 0; i < amountText.length(); i++) {
				if (amountText.charAt(i) == ',') {
					comma++;
				}
			}
			String[] splitString = amountText.split(",");
			//System.out.println(amountText + " has been splited size : " + splitString.length);
			if (splitString.length != comma + 1) {
				return false;
			}
			for (int i = 0; i < splitString.length; i++) {
				//System.out.println(splitString[i]);
			}
			for (int i = 0; i < splitString.length; i++) {
				if (i == 0) {
					if (splitString[i].length() == 0) {
						//System.out.println(amountText + " has been cut in step 3");
						return false;
					} else {
						continue;
					}
				} else {
					if (splitString[i].length() != 3) {
						//System.out.println(amountText + " has been cut in step 3");
						return false;
					}
				}
			}
		}
		boolean answer = true;
		//System.out.println(amountText + " has been cleared");
		return answer;
	}
}
