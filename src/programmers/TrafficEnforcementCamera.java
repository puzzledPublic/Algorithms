package programmers;

import java.util.PriorityQueue;

//단속카메라
public class TrafficEnforcementCamera {
	public static void main(String[] args) {
		int[][][] routes = { {
				{-20, 15},
				{-14, -5},
				{-18, -13},
				{-5, -3}
			},{
				{-2, -1},
				{-1, 10},
				{5, 11}
			}
		};
		for(int i = 0; i < routes.length; i++) {
			System.out.println(solution(routes[i]));
		}
	}
	
	static class TrafficRoute {
		int start, end;
		TrafficRoute(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	static int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<TrafficRoute> pq = new PriorityQueue<>((a, b) -> a.end - b.end);	//끝나는 지점순으로 정렬
        for(int i = 0; i < routes.length; i++) {
        	if(routes[i][0] > routes[i][1]) {	//왼쪽 -> 오른쪽으로 진행하도록 고정
        		int temp = routes[i][0];
        		routes[i][0] = routes[i][1];
        		routes[i][1] = temp;
        	}
        	pq.add(new TrafficRoute(routes[i][0], routes[i][1]));
        }
        int current = Integer.MIN_VALUE;	//현재 설치한 카메라 위치
        while(!pq.isEmpty()) {	//각 차량의 구간을 순회하며
        	TrafficRoute tr = pq.poll();	
        	if(current < tr.start) {	//현재 차량 구간이 카메라 설치한 위치에 존재하지 않으면 설치
        		current = tr.end;	//끝나는 지점에 설치한다.
        		answer++;	//카메라 개수 증가
        	}
        }
        return answer;
    }
}
