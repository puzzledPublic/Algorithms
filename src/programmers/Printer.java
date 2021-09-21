package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//프린터
public class Printer {
	public static void main(String[] args) {
		int[][] priorities = {
				{2, 1, 3, 2},
				{1, 1, 9, 1, 1, 1}
		};
		int[] location = {2, 0};
		
		for(int i = 0; i < priorities.length; i++) {
			System.out.println(solution(priorities[i], location[i]));
		}
	}
	
	static class Paper {
		int index, priority;
		Paper(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
	static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> queue = new LinkedList<>();	//프린터 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);	//출력 우선순위를 담는 큐(내림차순)
        for(int i = 0; i < priorities.length; i++) {
        	queue.add(new Paper(i, priorities[i]));	//문서 정보를 프린터 큐와 출력 우선순위 큐에 담는다.
        	pq.add(priorities[i]);
        }
        while(!queue.isEmpty()) {
        	Paper p = queue.poll();			//출력할 문서를 큐에서 하나 뽑는다.
        	if(p.priority == pq.peek()) {	//출력할 문서의 우선순위가 현재 최고 우선순위랑 같다면 출력.
        		answer++;
        		pq.poll();
        		if(p.index == location) {	//몇번쨰에 출력하는지 알고 싶어하는 문서라면 바로 종료.
        			break;
        		}
        	}else {							//현재 최고 우선순위가 출력할 문서의 우선순위보다 큰 경우 큐 맨뒤에 다시 넣는다.
        		queue.add(p);
        	}
        }
        return answer;
    }
}
