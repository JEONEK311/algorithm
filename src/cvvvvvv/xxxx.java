package cvvvvvv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class xxxx {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {9, 20, 28, 18, 11},new int[] {30, 1, 21, 17, 28})));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {

		String[] answer = new String[n];
		answer[0] = "1";

		int[] binary1 = new int[n];
		int[] binary2 = new int[n];

		String[][] map1 = new String[n][n];
		String[][] map2 = new String[n][n];


		for(int i=0 ; i<n ; i++) {
			binary1[i] = Integer.parseInt(Integer.toBinaryString(arr1[i]));
			binary2[i] = Integer.parseInt(Integer.toBinaryString(arr2[i]));
		}

		for(int i=0 ; i<n ; i++) {
			List<String> binaryMap1 = new ArrayList<String>();
			List<String> binaryMap2 = new ArrayList<String>();

			char[] crr1 = (binary1[i]+"").toCharArray();
			char[] crr2 = (binary2[i]+"").toCharArray();

			if(crr1.length<n) {
				int num1 = n - crr1.length;
				for(int a=0 ; a<num1 ; a++) {
					binaryMap1.add("0");
				}
			}

			if(crr2.length<n) {
				int num2 = n - crr2.length;
				for(int a=0 ; a<num2 ; a++) {
					binaryMap2.add("0");
				}
			}

			for(int a=0 ; a<crr1.length ; a++) {
				binaryMap1.add(crr1[a] + "");
			}

			for(int a=0 ; a<crr2.length ; a++) {
				binaryMap2.add(crr2[a] + "");
			}

			for(int j=0 ; j<n ; j++) {
				map1[i][j] = binaryMap1.get(j);
				map2[i][j] = binaryMap2.get(j);
			}
		}
		
		for(int i=0 ; i<n ; i++) {
			String result = "";
			for(int j=0 ; j<n ; j++) {
				if(map1[i][j].equals("0") && map2[i][j].equals("0"))
					result += " ";
				else
					result += "#";
			}
			answer[i] = result;
		}
		return answer;
	}
}