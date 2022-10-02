package mainPackage.coupang;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Solution {
	
	
	public static void main(String[] args) {
		long[] answer = solutionTest(1000000000000l);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
	
	public static long[] solutionTest(long n) {
		long[] answer = {-1, 1};
		for(long l = 1; l < n; l++) {
			long isPrimeAlpha = l;
			long isPrimeBeta = n/l;
			
			if(isPrimeLong(isPrimeAlpha) && isPrimeLong(isPrimeBeta)) {
				answer[0] = isPrimeAlpha;
				answer[1] = isPrimeBeta;
				return answer;
			}
		}
		return answer;
	}
	
	private static boolean isPrime(long longValue) {
		for(long l = 2; l <= Math.sqrt(longValue); l++) {
			if(longValue % l == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrimeLong(long number) {
	    return number > 1 
	      && LongStream.rangeClosed(2, (int) Math.sqrt(number))
	      .noneMatch(n -> (number % n == 0));
	}
}
