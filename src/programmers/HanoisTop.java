package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//하노이의 탑
public class HanoisTop {
	public static void main(String[] args) {
		int[] n = {2};
		
		for(int i = 0; i < n.length; i++) {
			int[][] result = solution(n[i]);
			for(int j = 0; j < result.length; j++) {
				System.out.println(Arrays.toString(result[j]));
			}
			System.out.println();
		}
	}
	
	static int[][] solution(int n) {
	    int[][] answer = {};
	    List<int[]> list = new ArrayList<>();
	    
	    hanoi(list, n, 1, 2, 3);
	    
	    answer = new int[list.size()][2];
	    for(int i = 0; i < list.size(); i++) {
	    	answer[i] = list.get(i);
	    }
	    return answer;
	}
	
	static void hanoi(List<int[]> list, int n, int start, int mid, int end) {
		if(n == 0) {
			return;
		}
		hanoi(list, n - 1, start, end, mid);	//start -> mid로 n원판을 옮긴다.
		list.add(new int[]{start, end});		//나머지 원판을 start -> end로 옮긴다
		hanoi(list, n - 1, mid, start, end);	//n원판을 mid -> end로 옮긴다.
	}
}
