package algo;

import java.util.Arrays;

public class prog42584 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1,2,3,2,3})));
//		solution(new int[] {1,2,3,2,3});
	}

	public static int[] solution(int[] prices) {

		int size = prices.length;
		int[] answer = new int[size];

		for(int i=0 ; i<size ; i++) {
			
			int cnt = 1;
			
			if(i==size-1) {
				cnt = 0;
			} else {
				for(int j=i+1 ; j<size-1 ; j++) {
					if(prices[i]<=prices[j]) {
//						System.out.println("i : " + prices[i] + ", j : " + prices[j]);
						cnt++;
					} else break;
				}
			}
				
			answer[i] = cnt;
		}
		return answer;
	}
}