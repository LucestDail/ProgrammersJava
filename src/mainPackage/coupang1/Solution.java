package mainPackage.coupang1;

import java.util.*;
public class Solution {
	
	
	public static void main(String[] args) {
		int[][] delivery = {{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};
		String answer = solutionTest(7, delivery);
		System.out.println(answer);
	}
	
	public static String solutionTest(int n, int[][] delivery) {
		
		// 재고 세팅
		TreeMap<Integer, Boolean> productMap = new TreeMap<>();
		for(int i = 1; i <= n; i++) {
			productMap.put(i, null);
		}
		
		for(int i = 0; i < delivery.length; i++) {

			int productAlpha = delivery[i][0];
			int productBeta = delivery[i][1];
			boolean isSuccess = delivery[i][2] == 1 ? true : false;
			
			// 배송 성공인 경우
			if(isSuccess) {
				productMap.put(productAlpha, true);
				productMap.put(productBeta, true);
			} else {// 배송 실패한 경우
				
				Boolean productAlphaValid = productMap.get(productAlpha);
				Boolean productBetaValid = productMap.get(productBeta);
				
				if(productAlphaValid != null && productAlphaValid) {
					// case 1. 1번 상품이 재고가 남은 경우
					productMap.put(productBeta, false);
				}else if(productBetaValid != null && productBetaValid) {
					// case 2. 2번 상품이 재고가 남은 경우
					productMap.put(productAlpha,false);
				}
				// case 3. 두 상품 확인이 안되는 경우 그냥 넘어간다.
			}
			
		}
		
		for(int i = 0; i < delivery.length; i++) {

			int productAlpha = delivery[i][0];
			int productBeta = delivery[i][1];
			boolean isSuccess = delivery[i][2] == 1 ? true : false;
			
			// 배송 성공인 경우
			if(isSuccess) {
				productMap.put(productAlpha, true);
				productMap.put(productBeta, true);
			} else {// 배송 실패한 경우
				
				Boolean productAlphaValid = productMap.get(productAlpha);
				Boolean productBetaValid = productMap.get(productBeta);
				
				if(productAlphaValid != null && productAlphaValid) {
					// case 1. 1번 상품이 재고가 남은 경우
					productMap.put(productBeta, false);
				}else if(productBetaValid != null && productBetaValid) {
					// case 2. 2번 상품이 재고가 남은 경우
					productMap.put(productAlpha,false);
				}
				// case 3. 두 상품 확인이 안되는 경우 그냥 넘어간다.
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Boolean> product : productMap.entrySet()) {
			if(product.getValue() != null && product.getValue()) {
				sb.append("O");
			} else if(product.getValue() != null && !product.getValue()) {
				sb.append("X");
			}else {
				sb.append("?");
			}
		}
		
		String answer = sb.toString();
		return answer;
		
	}
	
}