package kakao.kakao2017;

import java.util.LinkedList;
import java.util.Queue;

//2017 카카오코드 예선 
//카카오프렌즈 컬러링북
public class KakaoFriendsColoringBook {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		int m = 6, n = 4;
		int[][] picture = {
				{1,1,1,0},
				{1,2,2,0},
				{1,0,0,1},
				{0,0,0,1},
				{0,0,0,3},
				{0,0,0,3},
		};
		
		int[] result = solution(m, n, picture);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	
	static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		boolean[][] checkBoard = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(picture[i][j] > 0 && !checkBoard[i][j]) {
					numberOfArea++;
					int sizeOfOneArea = dfs(picture, checkBoard, i, j);
					if(maxSizeOfOneArea < sizeOfOneArea) {
						maxSizeOfOneArea = sizeOfOneArea;
					}
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
	
	static int dfs(int[][] picture, boolean[][] checkBoard, int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		checkBoard[x][y] = true;
		queue.add(new Pos(x, y));
		int size = 1;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			for(int i = 0; i < 4; i++) {
				int xx = p.x + d[i][0];
				int yy = p.y + d[i][1];
				if((0 <= xx && xx < picture.length) && (0 <= yy && yy < picture[0].length)) {
					if(!checkBoard[xx][yy] && (picture[x][y] == picture[xx][yy])) {
						checkBoard[xx][yy] = true;
						queue.add(new Pos(xx, yy));
						size++;
					}
				}
			}
		}
		return size;
	}
}
