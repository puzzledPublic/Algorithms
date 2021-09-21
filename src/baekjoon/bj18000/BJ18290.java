package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//NM과 K(1)
public class BJ18290 {
	static int[][] arr;
	static boolean[][] chk;
	static int N, M, K;
	static int neg = Integer.MIN_VALUE;	//더한 값이 음수가 될 수 있으므로 0을 최소값으로 하지 않도록 주의
	static int max;
	static int[][] d = { { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		chk = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(dfs(0, 0, 0, 0) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static int dfs(int x, int y, int k, int t) {
		//K개를 선택하면 종료
		if (k == K) {
			return t;
		}
		
		//오른쪽으로 탐색하다가 마지막 열에 도착하면 다음 행으로 이동
		if (y == M) {
			return dfs(x + 1, 0, k, t);
		}
		
		//마지막 행까지 탐색했고 아직 K개를 선택 못했으면 종료
		if (x == N) {
			return neg;
		}

		//현재 위치 기준 왼쪽, 위가 이미 선택됐는지 검사.
		for (int i = 0; i < 2; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if (nx == -1 || ny == -1) {	//범위를 벗어나는 경우 무시
				continue;
			}
			else if (chk[nx][ny]) {	//이미 선택됐다면 다음으로 넘어간다.
				return dfs(x, y + 1, k, t);
			}
		}
		
		//현재 칸을 선택하는 경우.
		chk[x][y] = true;
		int result = dfs(x, y + 1, k + 1, t + arr[x][y]);
		chk[x][y] = false;
		
		//현재 칸을 선택하지 않는 경우.
		return Math.max(result, dfs(x, y + 1, k, t));
	}
}
