package kakao.kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//2번 실패율
public class FailureRate {
	public static void main(String[] args) {
		int[] N = {5, 4, 5, 4, 2};
		int[][] stages = {
				{2,1,2,6,2,4,3,3},
				{4,4,4,4,4},
				{6,6,6,6,6},
				{1,2,3,4,1},
				{1, 1}
		};
		for(int i = 0; i < N.length; i++) {
			System.out.println(Arrays.toString(solution(N[i], stages[i])));
		}
	}
	static class Failure {
		int index;
		double failure;
		public Failure(int index, double failure) {
			this.index = index;
			this.failure = failure;
		}
	}
	static int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] personOfStage = new int[N + 2];	//i번째 스테이지에 시도 중인 사람 수
        int[] pSum = new int[N + 2];			//i번째 스테이지를 시도한 사람.
        
        for(int i = 0; i < stages.length; i++) {
        	personOfStage[stages[i]]++;
        	pSum[stages[i]]++;
        }
        
        for(int i = N; i >= 1; i--) {	//거꾸로 부분합을 구한다.
        	pSum[i] += pSum[i + 1];
        }
        
        List<Failure> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
        	if(pSum[i] != 0) {	//분모가 0이 아닌 경우
        		list.add(new Failure(i, personOfStage[i] / (double)pSum[i]));	//실패율 = 현재 스테이지를 시도 중인 사람 / 현재 스테이지를 시도한 사람
        	}else {				//분모가 0인 경우 확률은 0
        		list.add(new Failure(i, 0));
        	}
        }
        Collections.sort(list, (a, b) -> -Double.compare(a.failure, b.failure));	//실패율 내림차순 정렬
        answer = list.stream().mapToInt(a -> a.index).toArray();	//실패율 내림차순대로 스테이지 출력
        return answer;
    }
}
