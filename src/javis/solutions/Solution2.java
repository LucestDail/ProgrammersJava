package javis.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution2 {
	static int finalCount = 1;
	static int finalNumber = 0;
	
	public static int[] solution(int[][] orders) {
		ArrayList<ArrayList<Integer>> ordersList = new ArrayList<ArrayList<Integer>>();
		for(int[] order : orders) {
			ordersList.add(convertArrayToArrayList(order));
		}
		election(ordersList, finalCount);
		int[] answer = new int[2];
		answer[0] = finalCount;
		answer[1] = finalNumber;
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		finalCount = 1;
		finalNumber = 0;
		return answer;
	}
	
	private static void election(ArrayList<ArrayList<Integer>> orders, int currentCount) {
		
		int[] answer = new int[2];
		
		// 각각의 후보에 해당하는 점수를 추출, 계산하여 최하위를 도출한다.
		HashMap<Integer, Integer> electionMap = new HashMap<>();
		for(ArrayList<Integer> order : orders) {
			int targetOrder = order.get(0);
			if(electionMap.containsKey(targetOrder)) {
				electionMap.put(targetOrder, (Integer)electionMap.get(targetOrder)+1);
			}else {
				electionMap.put(targetOrder, 1);
			}
		}
		
		// 만약 반수 이상을 획득한 사람이 있을 경우 반장으로 지정한다.
		int halfPoint = orders.size() % 2 == 0 ? orders.size() / 2 : (orders.size() + 1) / 2;
		HashMap<Integer, Integer> resultElectionMap = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : electionMap.entrySet()) {
			if(entry.getValue() >= halfPoint) {
				resultElectionMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		if(resultElectionMap.size() == 0) {
			// 최하위 대상을 찾는다.
			Integer minValue = Collections.min(electionMap.values());
			HashMap<Integer, Integer> resultFailElectionMap = new HashMap<>();
			for (Map.Entry<Integer, Integer> entry : electionMap.entrySet()) {
				if(entry.getValue() == minValue) {
					resultFailElectionMap.put(entry.getKey(), entry.getValue());
				}
			}
			
			// 동률인 경우 가장 작은 번호를 제거한다.
			Integer minKey = null;
			for(Integer key : resultFailElectionMap.keySet()) {
				if(minKey == null) {
					minKey = key;
				}else {
					if(minKey > key) {
						minKey = key;
					}
				}
			}

			// 모든 배열에서 최하위 값을 제거한다.
			ArrayList<ArrayList<Integer>> ordersList = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> order : orders) {
				order.remove(Integer.valueOf(minKey));
				ordersList.add(order);
			}
			
			// 재귀 호출한다
			election(orders, currentCount+1);
			
			
		}else if(resultElectionMap.size() == 1) {
			Optional<Integer> firstKey = resultElectionMap.keySet().stream().findFirst();
			
			Integer key = null;
			if(firstKey.isPresent()) {
			    key = firstKey.get();
			}
			finalCount = currentCount;
			finalNumber = key;
		}else {
			// 2명 이상인 경우에는 더 큰 번호가 당선된다.
			Integer electionNumber = 0;
			for(Integer key : resultElectionMap.keySet()) {
				if(key > electionNumber) {
					electionNumber = key;
				}
			}
			finalCount = currentCount;
			finalNumber = electionNumber;
		}
	}
	
	private static ArrayList<Integer> convertArrayToArrayList(int[] intArray) {
		
		ArrayList<Integer> covertIntArray = new ArrayList<>();
		
		for(int i : intArray) {
			covertIntArray.add(i);
		}
		
		return covertIntArray;
	}
}
