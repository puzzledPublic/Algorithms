package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//NxM 보드 완주하기
public class BJ9944 {
	static int result;
	static int N, M;
	static char[][] board;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		int caseCount = 1;
		while((input = br.readLine()) != null) {
			String[] nums = input.split(" ");
			N = Integer.parseInt(nums[0]);
			M = Integer.parseInt(nums[1]);
			board = new char[N][];
			
			for(int i = 0; i < N; i++) {			
				board[i] = br.readLine().toCharArray();
			}
			
			result = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(board[i][j] == '.') {
						dfs(i, j, 0);
					}
				}
			}
			bw.write("Case " + (caseCount++) + ": " + (result == Integer.MAX_VALUE ? -1 : result) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y, int c) {
		board[x][y] = 'x';
		int count = 0;
		
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if(!(0 <= nx && nx < N) || !(0 <= ny && ny < M) || (board[nx][ny] == '*') || (board[nx][ny] == 'x')) {	//바로 다음 위치가 갈 수 없는 곳이면 바로 다음 방향으로.
				count++;
				continue;
			}
			while((0 <= nx && nx < N) && (0 <= ny && ny < M) && board[nx][ny] == '.') {	//해당 방향으로 갈 수 있는 만큼 진행.
				board[nx][ny] = 'x';	//지나감 체크
				nx += d[i][0];
				ny += d[i][1];
			}
			
			nx -= d[i][0];
			ny -= d[i][1];
			
			dfs(nx, ny, c + 1);
			
			while(!(x == nx && y == ny)) {	//복구, 백트래킹.
				board[nx][ny] = '.';
				nx -= d[i][0];
				ny -= d[i][1];
			}
		}
		
		if(count == 4) {	//상하좌우 모든 방향으로 갈 수 없다면 종료.
			boolean full = true;
		tal: for(int i = 0; i < N; i++) {	//보드가 모두 채워졌는지 검사.
				for(int j = 0; j < M; j++) {
					if(board[i][j] == '.') {
						full = false;
						break tal;
					}
				}
			}
			if(full) {	//모두 채워 졌다면 움직인 횟수 갱신.
				result = Math.min(result, c);
			}
		}
		
		board[x][y] = '.';
	}
}
