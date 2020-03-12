package algo;

import java.util.Arrays;
import java.util.Queue;

public class budget {

	public static void main(String[] args) {

		System.out.println(solution(new int[] {1,3,2,5,4}, 9));
		
	}

	public static int solution(int[] d, int budget) {
		
		int sum = 0;
		int cnt = 0;

		Arrays.sort(d);
		
		for(int i=0 ; i<d.length ; i++) {
			
			if(sum+d[i]<=budget) {
				sum += d[i];
				cnt++;
			}
			
			else
				break;
		}	
		return cnt;
	}
}
