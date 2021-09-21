package programmers;

import java.util.Arrays;

//땅따먹기
public class Hopscotch {
	public static void main(String[] args) {
		int[][] land = {
				{1, 2, 3, 5},
				{5, 6, 7, 8},
				{4, 3, 2, 1}
		};
		
		System.out.println(solution(land));		
	}
	
	static int solution(int[][] land) {
        int answer = 0;
        for(int i = 1; i < land.length; i++) {	//land[i][j] = i행 j열에 도착했을때 가장 크게 얻는 점수
        	for(int j = 0; j < 4; j++) {
        		int max = 0;
        		land[i][j] += Math.max(land[i - 1][(j + 1) % 4], Math.max(land[i - 1][(j + 2) % 4], land[i - 1][(j + 3) % 4]));
        	}
        }
        return answer = Math.max(Math.max(land[land.length - 1][0], land[land.length - 1][1]), Math.max(land[land.length - 1][2], land[land.length - 1][3]));
    }
}
