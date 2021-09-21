package programmers;

import java.util.PriorityQueue;

//라면 공장
public class RamenFactory {
	public static void main(String[] args) {
		int stock = 4;
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10};
		int k = 30;
		
		System.out.println(solution(stock, dates, supplies, k));
	}
	
	static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int limit = stock, index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        while(limit < k) {
        	while(index < dates.length && dates[index] <= limit) {
        		pq.add(supplies[index]);
        		index++;
        	}
        	int max = pq.poll();
        	limit += max;
        	answer++;
        	if(index < dates.length && limit < dates[index]) {
        		while(!pq.isEmpty() && limit < dates[index]) {
        			max = pq.poll();
        			limit += max;
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
}
