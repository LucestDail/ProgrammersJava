package kodebox1;

import java.util.*;
import java.io.*;

class Set1 {

	static long longReturnValue = 0;
	static long[] longArraySortedInputArray;

	public static void main(String[] args) throws Exception {

		// 파라매터를 읽어온다.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		// 첫번째 파라매터를 가져온다(배열 크기)
		int intInputArraySize = Integer.parseInt(bufferedReader.readLine());
		longArraySortedInputArray = new long[intInputArraySize];
		long[] longArrayInputArray = new long[intInputArraySize];

		// 두번째 파라매터를 가져온다(배열 원소)
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < intInputArraySize; i++) {
			longArrayInputArray[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		// 정렬을 순회하여 반환 값을 설정한다.
		mergeSort(0, intInputArraySize - 1, longArrayInputArray);

		// 반환값을 출력한다.
		System.out.println(longReturnValue);
	}

	static void mergeSort(int intStartIndex, int intEndIndex, long[] longArrayInputArray) {
		if (intStartIndex < intEndIndex) {
			int intHalfIndex = (intStartIndex + intEndIndex) / 2;
			// 전반부 분할 재귀
			mergeSort(intStartIndex, intHalfIndex, longArrayInputArray);
			// 후반부 분할 재귀
			mergeSort(intHalfIndex + 1, intEndIndex, longArrayInputArray);

			// 병합
			int i = intStartIndex;
			int j = intHalfIndex + 1;
			int index = intStartIndex;

			while (i <= intHalfIndex && j <= intEndIndex) {
				if (longArrayInputArray[i] <= longArrayInputArray[j]) {
					longArraySortedInputArray[index++] = longArrayInputArray[i++];
				} else {
					longArraySortedInputArray[index++] = longArrayInputArray[j++];

					// 전반부 배열이 있는 만큼 정렬 대상이므로 크기만큼 스왑 횟수 증가
					longReturnValue += (intHalfIndex + 1 - i);
				}
			}

			// 전반부 잔여 배열을 병합한다.
			while (i <= intHalfIndex) {
				longArraySortedInputArray[index++] = longArrayInputArray[i++];
			}

			// 후반부 잔여 배열을 병합한다.
			while (j <= intEndIndex) {
				longArraySortedInputArray[index++] = longArrayInputArray[j++];
			}

			// 진행된 상태를 저장해서 재귀에 반환한다.
			for (int k = intStartIndex; k <= intEndIndex; k++) {
				longArrayInputArray[k] = longArraySortedInputArray[k];
			}
		}
	}
}