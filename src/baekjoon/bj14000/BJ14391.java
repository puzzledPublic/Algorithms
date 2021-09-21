package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//종이 조각
//백트래킹으로 완전탐색한 결과 시간이 느리다.
//4x4이므로 비트마스킹을 사용하면 시간을 줄일 수 있다.
public class BJ14391 {
	static int[][] chk;
	static int[][] arr;
	static int N, M;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N][M];
		chk = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				arr[i][j] = line[j] - '0';
			}
		}

		solve(0, 0, 0);
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void solve(int x, int y, int sum) {
		if (x == N) {	//다 자른경우
			if(max < sum) {
				max = sum;
			}
			return;
		}

		// 1xj (가로로 자르는 경우)
		boolean can = true;
		for (int j = 0; j < M; j++) {
			if (y + j < M) {
				for (int k = 0; k <= j; k++) {	//(x, y)에서 (x, y+j)까지 자를 수 있는지 검사.
					if (chk[x][y + k] != 0) {
						can = false;
						break;
					}
				}
				if (can) {	//자를 수 있다면.
					//체크 해주면서 숫자를 만든다.
					int mul = (int)Math.pow(10, j);
					int num = 0;
					for (int k = 0; k <= j; k++) {
						chk[x][y + k] = 1;	//체크
						num += arr[x][y + k] * mul; //숫자 생성
						mul /= 10;
					}
					
					//다음 자르기 시작 할 위치를 탐색.
					int nx = x, ny = y;
					while (nx != N && chk[nx][ny] != 0) {
						if (ny == M - 1) {
							nx++;
							ny = 0;
						} else {
							ny++;
						}
					}
					
					solve(nx, ny, sum + num);
					
					//백트래킹. 원래대로 복구.
					for (int k = 0; k <= j; k++) {
						chk[x][y + k] = 0;
					}

					can = true;
				}
			}
		}

		// ix1 (세로로 자르는 경우)
		can = true;
		for (int i = 0; i < N; i++) {
			if(x + i < N) {
				for (int k = 0; k <= i; k++) {
					if (chk[x + k][y] != 0) {
						can = false;
						break;
					}
				}
				if (can) {
					int mul = (int)Math.pow(10, i);
					int num = 0;
					for (int k = 0; k <= i; k++) {
						chk[x + k][y] = 2;
						num += arr[x + k][y] * mul;
						mul /= 10;
					}

					int nx = x, ny = y;
					while (nx != N && chk[nx][ny] != 0) {
						if (ny == M - 1) {
							nx++;
							ny = 0;
						} else {
							ny++;
						}
					}

					solve(nx, ny, sum + num);

					for (int k = 0; k <= i; k++) {
						chk[x + k][y] = 0;
					}

					can = true;
				}
			}
		}
	}
}
