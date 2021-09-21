package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Two Dots
public class BJ16929 {
	static int N, M;	//게임 판 크기 NxM
	static char[][] board;	//게임 판
	static int[][] chk;	//방문 체크 배열
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean hasCycle;	//사이클 여부
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][];
		chk = new int[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		tal:for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(chk[i][j] == 0) {	//아직 탐색 안했으면 해당 위치를 시작으로 탐색.
					dfs(i, j, board[i][j], 1);
				}
				if(hasCycle) {
					break tal;
				}
			}
		}
		
		bw.write((hasCycle ? "Yes\n" : "No\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int x, int y, char ch, int next) {	//ch = 현재 문자로만 이루어진 경로. next = 바로 전 위치를 탐색해 사이클이라고 판단하지 않도록 둔 순서.
		if(hasCycle) {
			return;
		}
		chk[x][y] = next;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];	//다음 방문 위치 계산.
			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && board[nx][ny] == ch) {	//같은 문자면서
				if(chk[nx][ny] > 0) {	//이미 방문했다면
					if(next - chk[nx][ny] != 1) {	//바로 전 방문한 곳이 아니라면 사이클이 있다.
						hasCycle = true;
						return;
					}
				}else {	//그 외의 경우 계속 탐색.
					dfs(nx, ny, ch, next + 1);
				}
			}
		}
	}
}
