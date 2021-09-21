package programmers;

import java.util.HashSet;
import java.util.Set;

//숫자 야구
public class BaseballGame {
	public static void main(String[] args) {
//		int[][] baseball = {
//				{123, 1, 1},
//				{356, 1, 0},
//				{327, 2, 0},
//				{489, 0, 1}
//		};
		int[][] baseball = {
				{327, 2, 0},
		};
		System.out.println(solution(baseball));
	}
	static int solution(int[][] baseball) {
        int answer = 0;
        int[][] nums = new int[baseball.length][3];
        for(int i = 0; i < baseball.length; i++) {
        	for(int j = 2; j >= 0; j--) {
        		nums[i][j] = baseball[i][0] % 10;
        		baseball[i][0] /= 10;
        	}
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 111; i < 1000; i++) {	//111 ~ 1000까지 탐색
        	int[] num = new int[3];
        	int t = i;
        	for(int j = 2; j >= 0; j--) {	//각 자리수대로 분리
        		num[j] = t % 10;
        		t /= 10;
        	}
        	for(int k = 0; k < 3; k++) {
        		set.add(num[k]);
        	}
        	if(set.size() < 3 || set.contains(0)) {	//3자리 수의 각 숫자는 중복되지 않으며 1 ~ 9 사이이다.
        		set.clear();
        		continue;
        	}
        	int count = 0;
        	for(int j = 0; j < nums.length; j++) {	//주어진 숫자에 대해 검사
	    	   int strike = 0, ball = 0;
	    	   for(int k = 0; k < 3; k++) {		//숫자가 들어있다면 ball++
	    		   if(set.contains(nums[j][k])) {
	    			   ball++;
	    		   }
	    	   }
	    	   for(int k = 0; k < 3; k++) {	//자리수가 일치하면 strike++, ball--
	    		   if(num[k] == nums[j][k]) {
	    			   strike++;
	    			   ball--;
	    		   }
	    	   }
	    	   if(baseball[j][1] == strike && baseball[j][2] == ball) {	//조건이 일치하면 count++
	    		   count++;
	    	   }
        	}
        	if(count == baseball.length) {	//주어진 모든 수에 조건이 맞다면 해당 숫자는 가능성 있는 숫자.
        		answer++;
        	}
        	set.clear();
        }
        return answer;
    }
}
