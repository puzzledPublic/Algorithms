package kakao.kakao2017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//캠핑
public class Camping {
	public static void main(String[] args) {
		int n = 4;
		int[][] data = {
			{0,0},{1,1},{0,2},{2,0}
		};
		
		System.out.println(solution(n, data));
	}
	
	static int solution(int n, int[][] data) {
		int answer = 0;
		//좌표압축
		List<Integer> listX = new ArrayList<>();
		List<Integer> listY = new ArrayList<>();
		
		for(int i = 0; i < data.length; i++) {
			listX.add(data[i][0]);
			listY.add(data[i][1]);
		}
		
		List<Integer> uniqueX = new ArrayList<>(new HashSet<>(listX));
		List<Integer> uniqueY = new ArrayList<>(new HashSet<>(listY));
		
		Collections.sort(uniqueX);
		Collections.sort(uniqueY);
		
		int[][] s = new int[n + 1][n + 1];

		for(int i = 0; i < data.length; i++) {
			data[i][0] = uniqueX.indexOf(new Integer(data[i][0]));
			data[i][1] = uniqueY.indexOf(new Integer(data[i][1]));
			s[data[i][0]][data[i][1]] = 1;
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i - 1 >= 0 && j - 1 >= 0) {
					s[i][j] -= s[i - 1][j - 1];
				}
				if(i - 1 >= 0) {
					s[i][j] += s[i - 1][j];
				}
				if(j - 1 >= 0) {
					s[i][j] += s[i][j - 1];
				}
			}
		}
		
		for(int i = 0; i < data.length - 1; i++) {
			for(int j = i + 1; j < data.length; j++) {
				if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) {
					continue;
				}
				
				int startX = Math.min(data[i][0], data[j][0]);
				int startY = Math.min(data[i][1], data[j][1]);
				int endX = Math.max(data[i][0], data[j][0]);
				int endY = Math.max(data[i][1], data[j][1]);
				
				if(startX + 1 > endX - 1 || startY + 1 > endY - 1) {	//ex) (0,0),(1,1)인 경우
					answer++;
				}
				else if(s[endX - 1][endY - 1] - s[endX - 1][startY] - s[startX][endY - 1] + s[startX][startY] == 0) {
					answer++;
				}
			}
		}
		
		return answer;
	}
}
