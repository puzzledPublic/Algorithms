package programmers;

import java.util.Arrays;

//체육복
public class GymSuit {
	public static void main(String[] args) {
		int[] n = {5, 5};
		int[][] lost = {
				{2, 4},
				{2, 4}
		};
		int[][] reserve = {
				{1, 3, 5},
				{3},
		};
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], lost[i], reserve[i]));
		}
	}
	
	static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] gymSuit = new int[n + 2];
        Arrays.fill(gymSuit, 1);	//모두 1개씩 체육복이 있다고 하자
        for(int i = 0; i < lost.length; i++) {	//체육복을 잃어버린 학생에서 체육복 갯수를 줄인다.
        	gymSuit[lost[i]] = 0;
        }
        for(int i = 0; i < reserve.length; i++) {	//체육복 여벌이 있는 학생에서 체육복 갯수를 늘린다.
        	gymSuit[reserve[i]]++;
        }
        for(int i = 1; i < n + 1; i++) {	//모든 학생을 돌며
        	if(gymSuit[i] == 2) {	//여벌이 존재하고
	        	if(gymSuit[i - 1] == 0) {	//앞에 학생이 체육복이 없다면 여벌을 준다.
	        		gymSuit[i - 1] = 1;
	        		gymSuit[i] = 1;
	        	}else if(gymSuit[i + 1] == 0) {	//뒤에 학생이 체육복이 없다면 여벌을 준다.
	        		gymSuit[i + 1] = 1;
	        		gymSuit[i] = 1;
	        	}
        	}
        }
        for(int i = 1; i < n + 1; i++) {	//모두 분배한 후 체육복을 1개 이상 가진 학생 수를 센다.
        	if(gymSuit[i] > 0) {
        		answer++;
        	}
        }
        return answer;
    }
}
