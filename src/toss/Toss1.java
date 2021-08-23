package toss;
import java.util.*;
import java.lang.Math;

public class Toss1 {
	public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// 부가가치세 : 과세 금액 * 0.1
        // 과세 금액 = 공급가액 - 비과세금액
        // 공급대가 = 공급가액 + 부가가치세
        // if 봉사료 -> 공급대가 = 주문금액 - 봉사료
        // else -> 공급대가 = 주문금액
        // but, 공급대가 - 비과세금액 = 1 => 부가가치세 = 0
		
		
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

        long supplyPrice = orderAmount;
        if(serviceFee != 0) {
        	supplyPrice -= serviceFee;
        }
        long taxAmount = supplyPrice - taxFreeAmount;
        double tax = 0;
        if(taxAmount < 1) {
            tax = 0;
        }else {
        	tax = Math.ceil(taxAmount * 0.1);
        }
        long answer = (long) tax;
        return answer;
    }

	public static int[] solution(int[][] requestParameter1) {
		// TODO Auto-generated method stub
		return null;
	}
}
