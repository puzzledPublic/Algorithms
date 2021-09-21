package programmers;

import java.util.Arrays;

//H-Index
public class HIndex {
	public static void main(String[] args) {
		int[][] citations = {
				{3, 0, 6, 1, 5},
				{3, 5, 5, 6, 0, 4}
		};
		for(int i = 0; i < citations.length; i++) {
			System.out.println(solution(citations[i]));
		}
	}
	
	static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int[] copy = new int[citations.length + 1];
        int index = 1;
        for(int i = citations.length - 1; i >= 0; i--) {
        	copy[index++] = citations[i];
        }
        for(int i = 1; i < copy.length; i++) {
        	answer = Math.max(answer, Math.min(i, copy[i]));
        }
        
        return answer;
    }
}
