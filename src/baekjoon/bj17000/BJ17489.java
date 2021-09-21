package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//보물찾기
public class BJ17489 {
	static int N, M, L;
	static char[][] board;
	static boolean[][] chk;
	static char[] S;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean isInfinity = false;
	static int mx, my;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		S = br.readLine().toCharArray();
		
		board = new char[N][M];
		chk = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		dfs(0, 0, 0, 0);
		
		if(isInfinity || count == 0) {	//사이클이 있거나 아예 문자열을 만들지 못하는 경우
			bw.write("-1\n");
		}else {
			bw.write(count + "\n");	//최대 문자열 반복 횟수
			bw.write((mx + 1) + " " + (my + 1) + "\n");	//그때 문자열 끝의 위치
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y, int k, int t) {	//(x, y) 현재 위치, k - 현재 문자 인덱스, t - 지나온 문자열 횟수
		if(isInfinity) {	//사이클이 생겼다면 바로 리턴
			return;
		}
		if(board[x][y] == S[L - 1]) {	//문자열의 끝이면 보물장소 가능.
			t++;
			if(count < t) {	//문자열 반복 횟수가 최대가 되는 위치를 갱신
				count = t;
				mx = x;
				my = y;
			}
		}
		chk[x][y] = true;
		
		for(int i = 0; i < d.length; i++) {	//상, 하, 좌, 우 검사
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
				if(!chk[nx][ny] && board[nx][ny] == S[(k + 1) % L]) {	//아직 방문 안했고 다음 탐색할 문자인 경우
					dfs(nx, ny, (k + 1) % L, t);
				}else if(chk[nx][ny] && board[x][y] == S[L - 1] && board[nx][ny] == S[0]) {	//이미 방문했고 다음 탐색할 문자가 시작과 같은 경우 사이클 발생.
					isInfinity = true;	//사이클이 생겼다면 바로 리턴
					return;
				}
			}
		}
		chk[x][y] = false;	//다른 경로로 오는 경우 반복 횟수가 더 높을 수 있으므로 복구
	}
}