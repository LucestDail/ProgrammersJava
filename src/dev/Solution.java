package dev;

import java.util.regex.Pattern;

public class Solution {
	public static String sConditionString;
	public static String nConditionString;
	
	public static String solution(String[] registered_list, String new_id) {
        // new_id 가 이미 있는 ID인지 확인한다.
        if(isExist(registered_list, new_id)) {
        	//이미 있는 ID 인 경우 신규 ID 를 생성해서 반환한다.
        	return generateId(registered_list, new_id);
        }else {
        	return new_id;
        }
    }
	
	/**
	 * ID가 유효한 ID 인지를 판단한다.
	 * @param new_id
	 * @return
	 */
	private static boolean isValid(String new_id) {
		if(isValidConditionS(new_id) && isValidConditionN(new_id)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 제시한 S 조건인지 확인한다.
	 * @param new_id
	 * @return
	 */
	private static boolean isValidConditionS(String new_id) {
		
		for(int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if(Character.isDigit(c)) {
				// 숫자가 발생한 경우 해당 부분에서 바로 유효성 체크를 한 후, 결과를 반환한다.
				return isValidConditionSMinor(new_id.substring(0,i));
			}
			if(i > 6) {
				// 숫자가 안발생한 길이가 7 이상인 경우 즉시 유효성 검사를 종료한다.
				return false;
			}
		}
		return isValidConditionSMinor(new_id); // 통과
	}
	
	private static boolean isValidConditionSMinor(String statement) {
		if(statement.length() < 3 || statement.length() > 6) {
			// 길이가 3 ~ 6인지 확인한다.
			return false;
		}else {
			// 소문자 여부를 판별한다.
			for(int j = 0; j < statement.length(); j++) {
				if(Character.isUpperCase(statement.charAt(j))){
					return false;
				}
			}
			sConditionString = statement;
			return true;
		}
	}
	
	/**
	 * 제시한 N 조건인지 확인한다.
	 * @param new_id
	 * @return
	 */
	private static boolean isValidConditionN(String new_id) {
		// 최초 숫자가 발생 이후 끝 범위까지 자른다.
		for(int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if(Character.isDigit(c)) {
				// 숫자가 발생한 경우 해당 부분에서 바로 유효성 체크를 한 후, 결과를 반환한다.
				return isValidConditionNMinor(new_id.substring(i,new_id.length()));
			}
			if(i > 6) {
				// 숫자가 안발생한 숫자가 7 이상인 경우 즉시 유효성 검사를 종료한다.
				return false;
			}
		}
		// 숫자가 발생하지 않은 숫자중 길이가 6 이하인 문자열이므로, 통과한다.
		return true;
		
		
	}
	private static boolean isValidConditionNMinor(String statement) {
		if(statement.length() > 6) {
			// 길이가 0 ~ 6인지 확인한다.
			return false;
		}else {
			if(statement.length() == 0) {
				// 길이가 0인 경우
				return true;
			}else {
				// 1 이상인 경우, 우선 최초 자리가 0이면 통과하지 못한다.
				if(statement.charAt(0) == '0') {
					return false;
				}
				String pattern = "^[0-9]*$"; // 숫자만 등장하는지
				boolean result = Pattern.matches(pattern, statement);
				if(result) {
					nConditionString = statement;
					return result;
				}else {
					return false;
				}
			}
		}
	}
	
	/**
	 * ID 가 이미 존재하는지를 판단한다.
	 * @param registered_list
	 * @param new_id
	 * @return
	 */
	private static boolean isExist(String[] registered_list, String new_id) {
		for(String id : registered_list) {
			if(new_id.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ID 를 신규로 생성하는데, 이미 생성된 ID랑 중복되지 않는 ID 를 생성한다.
	 * @param registered_list
	 * @param new_id
	 * @return
	 */
	private static String generateId(String[] registered_list, String new_id) {
		String sConditionParseNewId = getInitString(new_id);
		String nConditionParseNewId = getInitNumber(new_id);
		if(nConditionParseNewId == null) {
			nConditionParseNewId = "0";
		}
		String returnId = null;
		boolean conditionBreakFlag = true;
		while(conditionBreakFlag) {
			int nValue = Integer.parseInt(nConditionParseNewId);
			nConditionParseNewId = Integer.toString(nValue + 1);
			String mergeConditionId = sConditionParseNewId + nConditionParseNewId;
			if(isValid(mergeConditionId)) {
				returnId = mergeConditionId;
				conditionBreakFlag = false;
			}
		}
		
		
		return "";
	}
	
	private static String getInitString(String inputId) {
		for(int i = 0; i < inputId.length(); i++) {
			char c = inputId.charAt(i);
			if(Character.isDigit(c)) {
				return inputId.substring(0,i);
			}
		}
		return inputId;
	}
	
	private static String getInitNumber(String inputId) {
		for(int i = 0; i < inputId.length(); i++) {
			char c = inputId.charAt(i);
			if(Character.isDigit(c)) {
				return inputId.substring(i,inputId.length());
			}
		}
		return null;
	}

}
