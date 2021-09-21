package programmers;

import java.util.PriorityQueue;

//더 맵게
public class MoreSpice {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
	static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        while(true) {
        	if(pq.size() == 1 && pq.peek() < K) {
        		answer = -1;
        		break;
        	}
        	int current = pq.poll();
        	if(current < K) {
        		int next = pq.poll();
        		pq.add(current + next * 2);
        		answer++;
        	}else {
        		break;
        	}
        }
        return answer;
    }
}
