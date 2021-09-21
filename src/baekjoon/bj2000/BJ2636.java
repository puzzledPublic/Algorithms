package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//치즈
public class BJ2636 {
	static int N, M, time = 1, amount, count;
	static int[][] cheese;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		do {
			count = 0;	//각 시간에 녹는 치즈 개수 초기화
			dfs(0, 0);	//치즈가 녹는다.
			time++;		//시간 증가
			if(count != 0) {	//녹은 치즈 개수가 0이 아니면 그 개수를 저장해 놓는다.
				amount = count;
			}
		}while(count > 0);	//녹은 치즈 개수가 0개라면 더 이상 치즈가 없으므로 종료
		
		bw.write((time - 2) + "\n" + amount);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y) {
		cheese[x][y] = -time;	//visited배열말고 직접 cheese판에 표시한다.
		for(int i = 0; i < 4; i++) {	//상하좌우 검사
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
				if(cheese[nx][ny] == 1) {	//치즈(1)라면 녹았음을 표시(-time)
					cheese[nx][ny] = -time;
					count++;	//녹은 치즈 개수 증가.
				}else if(cheese[nx][ny] > -time) {	//방문할 수 있는 곳이라면 계속 탐색
					dfs(nx, ny);
				}
			}
		}
	}
}
