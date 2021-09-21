package programmers;

import java.util.Arrays;

//모의고사
public class MockTest {
	public static void main(String[] args) {
		int[][] answers = {
				{1, 2, 3, 4, 5},
				{1, 3, 2, 4, 2},
		};
		for(int i = 0; i < answers.length; i++) {
			System.out.println(Arrays.toString(solution(answers[i])));
		}
	}
	static class Grade {
		int index, grade;
		public Grade(int index) {
			this.index = index;
		}
	}
	static int[] solution(int[] answers) {
        int[] answer = {};
        int[][] supo = {
        		{1, 2, 3, 4, 5},
        		{2, 1, 2, 3, 2, 4, 2, 5},
        		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        Grade[] g = new Grade[3];
        g[0] = new Grade(1);
        g[1] = new Grade(2);
        g[2] = new Grade(3);
        for(int i = 0; i < answers.length; i++) {
        	for(int j = 0; j < 3; j++) {
        		if(answers[i] == supo[j][i % supo[j].length]) {
        			g[j].grade++;
        		}
        	}
        }
        Arrays.sort(g, (a, b) -> { 
        	int diff = b.grade - a.grade;
        	if(diff == 0) {
        		return a.index - b.index;
        	}
        	return diff;
        });
        
        if(g[0].grade == g[1].grade && g[1].grade == g[2].grade) {
        	answer = new int[]{1, 2, 3};
        }else if(g[0].grade == g[1].grade) {
        	answer = new int[]{g[0].index, g[1].index};
        }else {
        	answer = new int[]{g[0].index};
        }
        return answer;
    }
}
