package java8_1;

import java.util.PriorityQueue;
//프로그래머스 2018 하반기 모의고사
//배상비용 최소화
public class ProgrammersTest2 {
	public static void main(String[] args) {
		int n = 4;
		int[] works = {4, 3, 3};
		System.out.println(solve(n, works));
	}
	
	static int solve(int no, int[] works) {
		int result = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for(int i = 0; i < works.length; i++) {
			pq.add(works[i]);
		}
		while(no > 0) {
			int s = pq.poll();
			if(s == 0) {
				break;
			}
			s--;
			no--;
			pq.add(s);
		}
		while(!pq.isEmpty()) {
			int t = pq.poll();
			result += t * t;
		}
		return result;
	}
}
