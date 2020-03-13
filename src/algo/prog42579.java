package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class prog42579 {

	public static void main(String[] args) {

//		System.out.println(Arrays.toString(solution(new String[] {"classic","pop","classic","classic","pop"}, new int[] {500,600,150,800,2500})));
		System.out.println(Arrays.toString(solution(new String[] {"classic","pop", "pop"}, new int[] {8000,4000,4000})));
//		solution(new String[] {"classic","pop","classic","classic","pop","jeon"}, new int[] {500,600,150,800,2500,100});

	}

	public static int[] solution(String[] genres, int[] plays) {

		List<Integer> ans = new ArrayList<Integer>();

		class Music{
			String genre;
			int playCnt;

			public Music(String genre, int playCnt) {
				this.genre = genre;
				this.playCnt = playCnt;
			}
		}

		int size = genres.length;
		List<Music> list = new ArrayList<Music>();	
		List<Music> cntCheck = new ArrayList<Music>();	
		List<String> category = new ArrayList<>();	//장르가 중복없이 들어가있다.
		Music music;
		boolean flag;

		for(int i=0 ; i<size ; i++) {
			music = new Music(genres[i], plays[i]);
			list.add(music);

			flag = false;
			for(int j=0 ; j<category.size() ; j++) {
				flag = false;
				if((music.genre).equals(category.get(j))) {
					flag = true;
					break;
				} 
			}
			if(!flag)
				category.add(music.genre);
		}
		for(int i=0 ; i<category.size() ; i++) {
			int totalCnt = 0;
			for(int j=0 ; j<size ; j++) {
				if(category.get(i).equals(list.get(j).genre)) {
					totalCnt += list.get(j).playCnt;
				}
			}
			music = new Music(category.get(i), totalCnt);
			cntCheck.add(music);
		}
		
		category.clear();
		
		for(int a=0 ; a<2 ; a++ ) {
			int maxCnt = 0;
			for(int i=0 ; i<cntCheck.size() ; i++) {
				maxCnt = Math.max(cntCheck.get(i).playCnt, maxCnt);
			}

			for(int i=0 ; i<cntCheck.size() ; i++) {
				if(cntCheck.get(i).playCnt == maxCnt) {
					category.add(cntCheck.get(i).genre);
					cntCheck.remove(i);
				}
			}
		}
		
		for(int i=0 ; i<2 ; i++) {
			
			String genre = category.get(i);
			List<Integer> cnt = new ArrayList<>();
			
			for(int j=0 ; j<size ; j++) {
				if(genre.equals(list.get(j).genre)) {
					cnt.add(list.get(j).playCnt);
				}
			}
			
			
			Collections.sort(cnt, Collections.reverseOrder());
			
			aaa : for(int j=0 ; j<cnt.size() ; j++) {
				for(int a=0 ; a<list.size() ; a++) {
					if(cnt.get(j) == list.get(a).playCnt){
						if(ans.size()<4) {
							ans.add(a);
						}
					}
				}
			}
		}
		int[] answer = new int[ans.size()];
		for(int i=0 ; i<ans.size() ; i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}
}