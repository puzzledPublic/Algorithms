package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//숫자 게임(그리디)
public class NumberGame {
	public static void main(String[] args) {
		int[][] A = {
				{5, 1, 3, 7},
				{2, 2, 2, 2}
		};
		int[][] B = {
				{2, 2, 6, 8},
				{1, 1, 1, 1}
		};
		for(int i = 0; i < A.length; i++) {
			System.out.println(solution(A[i], B[i]));
		}
	}
	
	static int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);		//A팀이 가진 자연수 정렬
        Arrays.sort(B);		//B팀이 가진 자연수 정렬
        Deque<Integer> deque = new LinkedList<>();
        for(int i = B.length - 1; i >= 0; i--) {	//내림차순으로 넣는다.
        	deque.addLast(B[i]);
        }
        for(int i = A.length - 1; i >= 0; i--) {
        	if(A[i] < deque.peekFirst()) {	//B팀 자연수가 더 크면 이겼으므로 승점 1점
        		answer++;
        		deque.pollFirst();
        	}else {							//B팀 자연수가 작거나 같으면 제일 작은 점수로 지는것이 승점을 최대화 할 수 있다.
        		deque.pollLast();
        	}
        }
        
        return answer;
    }
}
