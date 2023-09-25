package programmers;

import java.util.HashSet;
import java.util.Set;

//연속 부분 수열 합의 개수
public class ConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};

        System.out.println(solution(elements));
    }

    static int solution(int[] elements) {
        int answer = 0;

        int[] preSum = new int[elements.length + 1];
        for(int i = 1; i <= elements.length; i++) { //부분합
            preSum[i] = elements[i - 1] + preSum[i - 1];
        }

        Set<Integer> set = new HashSet<>();
        for(int s = 1; s <= elements.length; s++) { //부분 수열 크기
            for(int i = 0; i < elements.length; i++) {  //부분 수열 시작 위치
                int sum = 0;
                int start = i;  //부분 수열 시작 위치
                int end = i + s;    //부분 수열 끝 위치
                if(end > elements.length) { //원형 수열으로 보니까 배열 크기를 넘어가면 잘라준다 
                    end = elements.length;
                    sum = (preSum[end] - preSum[start]) + preSum[(i + s) % elements.length];
                }else {
                    sum = preSum[end] - preSum[start];
                }
                set.add(sum);
            }
        }
        answer = set.size();

        return answer;
    }
}
