package toss;
import java.util.*;
import java.lang.Math;

public class Toss1 {
	public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// �ΰ���ġ�� : ���� �ݾ� * 0.1
        // ���� �ݾ� = ���ް��� - ������ݾ�
        // ���޴밡 = ���ް��� + �ΰ���ġ��
        // if ����� -> ���޴밡 = �ֹ��ݾ� - �����
        // else -> ���޴밡 = �ֹ��ݾ�
        // but, ���޴밡 - ������ݾ� = 1 => �ΰ���ġ�� = 0
		
		
        // orderAmount : �ֹ��ݾ�
        // taxFreeAmount : ������ݾ�
        // serviceFee : �����

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
