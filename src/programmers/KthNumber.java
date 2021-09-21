package programmers;

import java.util.Arrays;

//K번째 숫자
public class KthNumber {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3},
		};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
	
	static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
        	int[] arr = new int[commands[i][1] - commands[i][0] + 1];
        	int t = 0;
        	for(int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
        		arr[t++] = array[j];
        	}
        	Arrays.sort(arr);
        	answer[i] = arr[commands[i][2] - 1];
        }
        
        return answer;
    }
}
