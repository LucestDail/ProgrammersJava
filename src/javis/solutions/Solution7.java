package javis.solutions;

import java.util.Arrays;

public class Solution7 {
	public static int solution(String[] args) {
		
		// 반환할 값을 선언한다.
		int returnValue = 0;
		
		// 조건에 따라서 들어온 문자열을 배열로 만든다.
		int[] intArray = Arrays.stream(args[1].split(" "))
			    .mapToInt(Integer::parseInt)
			    .toArray();
		
		// 배열 전체를 순회한다.
		for(int i = 0; i < intArray.length; i++) {
		// 정렬 대상 범위를 순회한다.
			for(int j = 0; j < intArray.length - (i + 1); j++) {
		// 순회 도중 현재값보다 다음값이 더 큰 경우, 스왑한다.
				if(intArray[j] > intArray[j + 1]) {
					returnValue++;
					int bufValue = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = bufValue;
				}
			}
		}
		
		// 값을 반환한다.
		return returnValue;
	}
	
}


class Planet {
	private int x;
	private int y;
	private int z;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}