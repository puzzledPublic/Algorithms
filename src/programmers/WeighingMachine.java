package programmers;

import java.util.Arrays;

//저울
public class WeighingMachine {
	public static void main(String[] args) {
		int[][] weight = {
				{3, 1, 6, 2, 7, 30, 1},
				{1, 1, 2, 9},
		};
		for(int i = 0; i < weight.length; i++) {
			System.out.println(solution(weight[i]));
		}
	}
	//오름차순으로 추를 정렬 후 1부터 시작하여 추들을 더해갈때 
	//현재까지 더한 값(sum)이 다음에 더할 추보다 작은 경우
	//현재까지 더한 값이 구할 수 없는 최소값이 된다.
	static int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        int sum = 1;
        for(int i = 0; i < weight.length; i++) {
        	if(sum < weight[i]) {
        		break;
        	}
        	sum += weight[i];
        }
        return answer = sum;
    }
}
