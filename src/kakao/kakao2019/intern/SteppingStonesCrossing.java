package kakao.kakao2019.intern;

import java.util.Arrays;

//징검다리 건너기
public class SteppingStonesCrossing {
	public static void main(String[] args) {
		int[] stones = {3, 4, 5};//{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 1;
		
		System.out.println(solution(stones, k));
	}
	
	static int solution(int[] stones, int k) {
        int answer = 0;
        
        int[] sub = Arrays.copyOf(stones, stones.length);
        
        int start = 1, end = 200_000_000;
        
        while(start < end) {	//징검다리를 mid명이 건널 수 있는가?를 이분탐색.
        	int mid = (start + end) / 2;
        	boolean canCross = true;
        	
        	for(int i = 0; i < sub.length; i++) {	//mid명이 건너가면 각 돌의 내구도는 mid만큼 감소.
        		sub[i] = stones[i] - mid;
        	}
        	
        	int s = -1, e = -1;
        	for(int i = 0; i < sub.length; i++) {	//내구도가 0이하인 돌이 k개 이상 연속하면 더이상 건널 수 없다.
        		if(sub[i] <= 0) {
        			if(e < 0) {
        				s = e = i;
        			}else {
        				e++;
        			}
        		}else {
        			if(e != -1 && e - s + 1 >= k) {
        				canCross = false;
        				break;
        			}
        			s = e = -1;
        		}
        	}
        	if(e != -1 && e - s + 1 >= k) {	//모두 내구도가 0인 경우를 위해 마지막으로 검사.
        		canCross = false;
        	}
        	
        	if(canCross) {	//건널 수 있다면 건너는 사람 수를 늘려본다.
        		start = mid + 1;
        	}else {	//건널 수 없다면 건너는 사람 수를 줄여본다.
        		end = mid;
        	}
        }
        
        return answer = start;
    }
}
