package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//구명보트
public class LifeBoat {
	public static void main(String[] args) {
		int[][] people = {
				{70, 50, 80, 50},
				{70, 80, 50},
				{40, 60, 80, 100, 110},
				{100, 100, 100, 100, 100},
		};
		int[] limit = {100, 100, 150, 200};
		for(int i = 0; i < people.length; i++) {
			System.out.println(solution(people[i], limit[i]));
		}
	}
	static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<people.length; i++) {deque.push(people[i]);}	//스택처럼 push

        while(!deque.isEmpty()) {
            answer++;
            int std = deque.pollFirst();
            if(!deque.isEmpty()) {
                if(std + deque.peekLast() <= limit) {
                    deque.pollLast();
                }
            }
        }
        return answer;
    }
	//정렬한 후 한 사람을 보트에 태우고 남은 사람들 중 남은 보트 무게보다 적으면서 가장 몸무게가 무거운 사람을 골라 태운다.
	static int solution2(int[] people, int limit) {
        int answer = 0;
        
        boolean[] chk = new boolean[people.length];
        Arrays.sort(people);
        for(int i = 0; i < people.length; i++) {
        	if(!chk[i]) {
        		chk[i] = true;
        		int closestIndex = closestLimit(people, chk, limit - people[i]);
        		if(!chk[closestIndex]) {
        			chk[closestIndex] = true;
        		}
        		answer++;
        	}
        }
        
        return answer;
    }
	//제한 무게에 가장 근접한 사람을 찾기 위한 이분 탐색
	static int closestLimit(int[] people, boolean[] chk, int limit) {
		int start = 0, end = people.length - 1;
		while(start < end) {
			int mid = (start + end) / 2;
			if(people[mid] > limit) {
				end = mid;
			}else {
				start = mid;
			}
			if(start + 1 == end) {
				if(people[end] <= limit) {
					while(end >= 0 && chk[end--]);	//이미 태운사람이면 다음 사람을 찾아본다.
					end++;
					return end;
				}else {
					while(start >= 0 && chk[start--]);
					start++;
					return start;
				}
			}
		}
		return start;
	}
}
