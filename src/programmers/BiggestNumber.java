package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//가장 큰 수
public class BiggestNumber {
	public static void main(String[] args) {
		int[][] numbers = {
				{6, 10, 2},
				{3, 30, 34, 5, 9},
				{0, 0, 0, 0}
		};
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(solution(numbers[i]));
		}
	}
	
	static String solution(int[] numbers) {
        String answer = "";
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
        	list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
        	String as = String.valueOf(a), bs = String.valueOf(b);
        	return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        for(Integer i : list) {
        	answer += i;
        }
        if(answer.charAt(0) == '0') {
        	return "0";
        }else {
        	return answer;
        }
    }
}
