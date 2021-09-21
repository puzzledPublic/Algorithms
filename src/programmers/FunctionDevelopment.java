package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//기능개발
public class FunctionDevelopment {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55, 40};
		int[] speeds = {1, 30, 5, 5};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
        	int limit = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;	//며칠에 작업이 끝나는지 확인
        	int count = 0;
        	while(i < progresses.length && limit * speeds[i] >= 100 - progresses[i]) {	//해당 일 수내에 끝나는 작업들을 모두 제출.
        		i++;
        		count++;
        	}
        	list.add(count);
        	i--;
        }
        answer = list.stream().mapToInt((a) -> a).toArray();
        return answer;
    }
}
