package programmers;

import java.util.Arrays;
import java.util.Stack;

//탑
public class Top {
	public static void main(String[] args) {
		int[][] heights = {
				{6, 9, 5, 7, 4},
				{3, 9, 9, 3, 5, 7, 2},
				{1, 5, 3, 6, 7, 6, 5}
		};
		for(int i = 0; i < heights.length; i++) {
			System.out.println(Arrays.toString(solution(heights[i])));
		}
	}
	static class TopInfo {
		int index, height;
		public TopInfo(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
	static int[] solution(int[] heights) {
        int[] answer = {};
        answer = new int[heights.length];
        Stack<TopInfo> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
        	while(!stack.isEmpty() && stack.peek().height <= heights[i]) {
        		stack.pop();
        	}
        	if(stack.isEmpty()) {
        		answer[i] = 0;
        	}else {
        		answer[i] = stack.peek().index + 1;
        	}
        	stack.add(new TopInfo(i, heights[i]));
        }
        
        return answer;
    }
}
