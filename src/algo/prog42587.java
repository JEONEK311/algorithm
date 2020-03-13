package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class prog42587 {

	public static void main(String[] args) {

		//[2, 1, 3, 2], 2, 1
		//[1, 1, 9, 1, 1, 1], 0, 5

		//		System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));

	}

	public static int solution(int[] priorities, int location) {

		class Element {
            int val;
            boolean flag;
        }

        int answer = 0;
        int size = priorities.length;

        Element[] arr = new Element[size];
        LinkedList<Element> q = new LinkedList<>();
        List<Element> list = new ArrayList<>();

        for(int i=0 ; i<size ; i++) {
            Element e = new Element();
            if(i==location) {
                e.val = priorities[i];
                e.flag = true;
                q.offer(e);
            } else {
                e.val = priorities[i];
                e.flag = false;
                q.offer(e);
            }
        }

        while(!q.isEmpty()) {

            Element el = q.poll();
            boolean flag = false;

            //만약 배열에 젤 앞의 값보다 큰 값이 있으면 true + offer / 없으면 false
            for(int i=0 ; i<q.size() ; i++) {
                if(el.val<q.get(i).val) { 
                    flag = true;
                    q.add(el);
                    break;
                }
            }
            if(!flag) 
                list.add(el);
        }

        for(int i=0 ; i<list.size() ; i++) {
            if(list.get(i).flag) {
                answer = i + 1;
            }
        }
        return answer;
	}
}