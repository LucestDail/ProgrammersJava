package javis.solutions;

import java.util.ArrayList;
import java.util.TreeMap;

public class Solution4 {
	
	static Integer commonValue = null;
	static Integer commonFrom = null;
	static Integer totalStackCount = null;
	static TreeMap<Integer, ArrayList<Integer>> queriesData = new TreeMap<Integer, ArrayList<Integer>>();
	static ArrayList<Integer> popResultArray = new ArrayList<Integer>();
	public static int[] solution(int n, int[][] queries) {
		totalStackCount = n;
		commonValue = null;
		commonFrom = null;
		queriesData = new TreeMap<Integer, ArrayList<Integer>>();
		popResultArray = new ArrayList<Integer>();
		
		initStack(n);
		
		for(int[] query : queries) {
			int targetStack = query[0];
			int targetValue = query[1];
			boolean isPop = query[1] == -1 ? true : false;
			
			ArrayList<Integer> modifyArrayList = queriesData.get(targetStack);
			
			if(isPop) {
				if(modifyArrayList.size() == 0) {
					if(checkCommonValueEmpty()) {
						popResultArray.add(-1);
						commonFrom = targetStack;
					}else {
						popResultArray.add(commonValue);
						popCommonValue(commonFrom);
						commonFrom = targetStack;
					}
				}else {
					popResultArray.add(modifyArrayList.get(modifyArrayList.size()-1));
					modifyArrayList.remove(modifyArrayList.size()-1);
					queriesData.put(targetStack, modifyArrayList);
				}
			}else {
				if(commonValue == null) {
					commonValue = targetValue;
					commonFrom = targetStack;
				}else {
					modifyArrayList.add(targetValue);
				}
			}
		}
		
		int[] answer = new int[popResultArray.size()];
		for(int i = 0; i < popResultArray.size(); i++) {
			answer[i] = popResultArray.get(i);
		}
		
        return answer;
    }
	
	private static boolean checkCommonValueEmpty() {
		return commonValue == null;
	}
	
	private static void popCommonValue(Integer commonFroms) {
		commonValue = null;
		for(int i = 1; i <= totalStackCount; i++) {
			Integer stackNum = i + commonFroms;
			if(stackNum > totalStackCount) {
				stackNum -= totalStackCount;
			}
			ArrayList<Integer> targetArray = queriesData.get(stackNum);
			if(commonValue == null) {
				if(targetArray.size() > 0) {
					commonValue = targetArray.get(0);
					targetArray.remove(0);
					queriesData.put(stackNum, targetArray);
				}
			}
		}
	}
	
	private static void initStack(int n) {
		for(int i = 1; i <= n; i++){
			queriesData.put(i, new ArrayList<Integer>());
		}
	}
}
