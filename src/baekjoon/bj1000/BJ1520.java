package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//내리막길	(DFS + DP)문제	DP배열을 방문체크 및 경로 수 캐쉬로 사용하자.
public class BJ1520 {
	static int[][] Map;
	static int[][] DP;
	static int[][] di = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
		Map = new int[m][n];
		DP = new int[m][n];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				DP[i][j] = -1;
			}
		}
		System.out.println(solve(0, 0));
		br.close();
	}
	// DP[i][j] = -1(방문안함), 0(방문), 0이상(경로 수)
	static int solve(int x, int y) {
		if(x == Map.length - 1 && y == Map[0].length - 1) {	//끝점까지 도달한 경우
			return 1;	
		}
		if(DP[x][y] != -1) {	//이미 x,y 이후의 경로 탐색이 됐다면 경로 수 리턴
			return DP[x][y];
		}
		DP[x][y] = 0;	//방문
		for(int i = 0; i < di.length; i++) {	//상하좌우 
			int nextX = x + di[i][0];
			int nextY = y + di[i][1];
			if(0 <= nextX && nextX < Map.length && 0 <= nextY && nextY < Map[0].length) {	//범위를 넘지 않고
				if(Map[nextX][nextY] < Map[x][y]) {	//내리막이라면
					DP[x][y] += solve(nextX, nextY);	//다음 경로 탐색
				}
			}
		}
		return DP[x][y];
	}
}
