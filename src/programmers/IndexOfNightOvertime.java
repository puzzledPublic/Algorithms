package programmers;

import java.util.PriorityQueue;

//야근지수
public class IndexOfNightOvertime {
	public static void main(String[] args) {
		int[][] works = {
				{4, 3, 3},	//12
				{2, 1, 2},	//6
				{1, 1},		//0
				{16, 29, 27, 1, 9, 18, 7, 3, 27, 2, 1, 16, 26, 2, 3, 8, 25, 0, 24, 29}	//201
		};
		int[] n = {4, 1, 3, 214};
		for(int i = 0; i < works.length; i++) {
			System.out.println(solution(n[i], works[i]));
		}
	}
	
	static long solution(int n, int[] works) {
       long answer = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
       for(int i = 0; i < works.length; i++) {	//작업량을 내림차순으로 정렬
    	   pq.add(works[i]);
       }
       while(n > 0) {	//남은 시간동안
    	  int top = pq.poll();			//제일 많은 작업량과
    	  if(n >= top - pq.peek()) {	//다음 많은 작업량과 차이가 현재 남은 시간보다 크고
    		  if(top == pq.peek()) {	//혹시 제일 많은 작업량과 다음 많은 작업량이 같으면
    			  n -= 1;				//남은 시간을 1 줄인다.
    			  pq.add(top - 1);
    		  }else {					//아니라면
    			  n -= (top - pq.peek());	//차이만큼 남은시간에서 차감
    			  pq.add(pq.peek());
    		  }
    	  }else {						//다음 많은 작업량과 차이가 현재 남은 시간보다 적으면
    		  top -= n;					//n만큼 작업을 한다.
    		  n = 0;					//남은시간 소진
    		  pq.add(top);				//남은 작업량 추가
    	  }
       }
       for(Integer i : pq) {
    	   if(i > 0) {
    		   answer += i * i;
    	   }
       }
       return answer;
    }
}
