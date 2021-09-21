package java8_1;

import java.util.Arrays;

public class Lg1 {
	public static void main(String[] args) {
		int[][] people = {
				{2, 3, 4,},
				{1, 2, 2},
		};
		int[][] tshirts = {
				{1,2,4,5},
				{1, 1}
		};
		for(int i = 0; i < people.length; i++) {
			System.out.println(solution(people[i], tshirts[i]));
		}
	}
	static int solution(int[] people, int[] tshirts) {
        int answer = 0;
        
        Arrays.sort(people);
        Arrays.sort(tshirts);
        int a = 0, b = 0;
        while(a < people.length && b < tshirts.length) {
        	if(people[a] <= tshirts[b]) {
        		a++;
        		b++;
        		answer++;
        	}else {
        		b++;
        	}
        }
        return answer;
    }
}
